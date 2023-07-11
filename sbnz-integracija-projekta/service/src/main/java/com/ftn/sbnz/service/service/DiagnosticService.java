package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.model.helper.*;
import com.ftn.sbnz.service.dto.AnswerDTO;
import com.ftn.sbnz.service.dto.DepressionMarkDTO;
import com.ftn.sbnz.service.dto.ResultDTO;
import com.ftn.sbnz.service.dto.TemplateParamDTO;
import com.ftn.sbnz.service.dto.rules.RuleDTO;
import com.ftn.sbnz.service.dto.rules.RuleParamDTO;
import com.ftn.sbnz.service.repository.DepressionMarkResultRepository;
import com.ftn.sbnz.service.repository.UserRepository;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class DiagnosticService {
    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResultService resultService;

    @Autowired
    private DepressionMarkResultRepository depressionMarkResultRepository;

    private DiagnosticTemplateService diagnosticTemplateService;

    private final KieContainer kieContainer;
    private KieSession kieSession;
    private String savedDrl;
    private List<String> paths;
    private List<DiagnosticTemplate> templateRules;
    private Random rand;
    @Autowired
    public DiagnosticService(KieContainer kieContainer, DiagnosticTemplateService diagnosticTemplateService) throws IOException {
        this.rand = new Random();
        this.paths = new ArrayList<>();
        this.diagnosticTemplateService = diagnosticTemplateService;
        this.templateRules = diagnosticTemplateService.getAll();
        //this.createTemplateRules();
        this.kieContainer = kieContainer;
        this.kieSession = this.createSession(true);

    }

    public ArrayList<String> back(String symptomType) {

        kieSession.insert(new DiagnosticState("USLOVI_ZA_ANKSIOZNOST", "ANKSIOZNOST"));
        kieSession.insert(new DiagnosticState("ANKSIOZNOST", "GENERALNI_ANKSIOZNI_POREMECAJ"));

        kieSession.insert(new DiagnosticState("USLOVI_ZA_PANICNI_NAPAD", "PANICNI_NAPAD"));
        kieSession.insert(new DiagnosticState("PANICNI_NAPAD", "PANICNI_POREMECAJ"));

        kieSession.insert(new DiagnosticState("USLOVI_ZA_SOCIJALNU_ANKSIOZNOST", "SOCIJALNA_ANKSIOZNOST"));
        kieSession.insert(new DiagnosticState("SOCIJALNA_ANKSIOZNOST", "SOCIJALNA_FOBIJA"));

        FactHandle symptom = kieSession.insert(symptomType);
        int fired = this.kieSession.fireAllRules();
        this.kieSession.delete(symptom);

        ArrayList<String> result = new ArrayList<>();
        Collection<Object> insertedObjects = (Collection<Object>) kieSession.getObjects();
        // Print the inserted objects
        for (Object insertedObject : insertedObjects) {
            System.out.println("Inserted Object: " + insertedObject);
            if (insertedObject instanceof String) {
                String s = (String) insertedObject;
                result.add(s);
                FactHandle factHandle = kieSession.getFactHandle(insertedObject);
                kieSession.delete(factHandle);
            }else if(insertedObject instanceof DiagnosticState){
                FactHandle factHandle = kieSession.getFactHandle(insertedObject);
                kieSession.delete(factHandle);
            }
        }

        System.out.println("back fired: " + fired);
        return result;
    }


    public ResultDTO postAnswers(List<AnswerDTO> answers, String loggedInUser) throws IOException {
        User user = this.userRepository.findByEmail(loggedInUser);//answers.get(0).getUserId()).orElseThrow(() -> new RuntimeException());
        FactHandle userFactHandle = kieSession.insert(user);
        List<FactHandle> factHandles = new ArrayList<>();
        factHandles.add(userFactHandle);

        QuestionLayer questionLayer = null;
        for (AnswerDTO answerDTO : answers) {
            Answer answer = this.answerService.saveAnswer(answerDTO, user);
            questionLayer = answer.getQuestion().getQuestionLayer();

            FullAnswer fullAnswer = new FullAnswer(answer.getId(), answer.getUser(), answer.getQuestion(),
                    answerDTO.getScore(), answer.getQuestion().isPositive());
            FactHandle ansInsert = kieSession.insert(fullAnswer);
            factHandles.add(ansInsert);

            kieSession.getAgenda().getAgendaGroup("transform-diagnostic").setFocus();
            kieSession.fireAllRules();
        }
        // System.out.println(fullAnswers);


        kieSession.getAgenda().getAgendaGroup("first-diagnostic").setFocus();
        int fired1 = kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("result-diagnostic").setFocus();
        int fired2 = kieSession.fireAllRules();

        System.out.println("*********** fired first diagnostic: " + fired1 + "  fired result: " + fired2);
        this.deleteFactHandles(factHandles);
        ResultDTO result = this.getDiagnosticWithLayerFromSession(user.getId(), questionLayer);
        this.resultService.saveResult(result, user);
        this.deleteFinalResultFromSession();
        System.out.println("result: " + result);
        return result;
    }

    private ResultDTO getDiagnosticWithLayerFromSession(long userId, QuestionLayer questionLayer) {
        System.out.println("question Layer: " + questionLayer);
        List<Diagnostic> diagnostics = new ArrayList<>();
        Collection<Object> insertedObjects = (Collection<Object>) kieSession.getObjects();
        // Print the inserted objects
        for (Object insertedObject : insertedObjects) {
            System.out.println("Inserted Object: " + insertedObject);
            if (insertedObject instanceof Diagnostic) {
                Diagnostic diagnostic = (Diagnostic) insertedObject;
                if (diagnostic.getUserId() == userId && diagnostic.getQuestionLayer() == questionLayer) {
                    diagnostics.add(diagnostic);
                }
            }
        }
        return new ResultDTO(diagnostics);
    }

    private void deleteFinalResultFromSession(){
        Collection<Object> insertedObjects = (Collection<Object>) kieSession.getObjects();
        for (Object insertedObject : insertedObjects) {
            if (insertedObject instanceof Diagnostic) {
                Diagnostic diagnostic = (Diagnostic) insertedObject;
                if(diagnostic.isFinalResult()){
                    FactHandle factHandle = kieSession.getFactHandle(insertedObject);
                    kieSession.delete(factHandle);
                }
            }
        }
    }

    public List<DepressionMarkDTO> depressionMark(String userEmail) {
        User user = this.userRepository.findByEmail(userEmail);
        FactHandle userFactHandle = kieSession.insert(user);
        List<Answer> answers = this.answerService.getAnswersByUserIdAndDate(user.getId());

        List<FactHandle> factHandles = new ArrayList<>();
        factHandles.add(userFactHandle);

        kieSession.insert(user);
        for (Answer answer : answers) {
            FullAnswer fullAnswer = new FullAnswer(answer.getId(), answer.getUser(), answer.getQuestion(),
                    answer.getScore(), answer.getQuestion().isPositive());
            FactHandle ansInsert = kieSession.insert(fullAnswer);
            factHandles.add(ansInsert);
        }

        kieSession.getAgenda().getAgendaGroup("depression-mark").setFocus();
        int fired = kieSession.fireAllRules();
        System.out.println(" depressiom mark fired: " + fired);
        this.deleteFactHandles(factHandles);
        List<DepressionMark> depressionMarks = this.analiseDepressionMarkAndDelete(user.getId());
        this.saveDepressionMarkResults(depressionMarks);
        return formDepressionMark(depressionMarks);
    }

    private List<DepressionMark> analiseDepressionMarkAndDelete(long userId) {
        List<DepressionMark> depressionMarks = new ArrayList<>();
        Collection<Object> insertedObjects = (Collection<Object>) kieSession.getObjects();
        // Print the inserted objects
        for (Object insertedObject : insertedObjects) {
            System.out.println("Inserted Object: " + insertedObject);
            if (insertedObject instanceof DepressionMark) {
                DepressionMark depressionMark = (DepressionMark) insertedObject;
                if (depressionMark.getUser().getId() == userId) {
                    depressionMarks.add(depressionMark);
                    FactHandle factHandle = kieSession.getFactHandle(insertedObject);
                    kieSession.delete(factHandle);
                }
            }
        }
        return depressionMarks;
    }

    private void saveDepressionMarkResults(List<DepressionMark> depressionMarks){
        for(DepressionMark dm: depressionMarks) {
            DepressionMarkResult dmr = new DepressionMarkResult();
            dmr.setUser(dm.getUser());
            dmr.setText(dm.getText());
            dmr.setTime(LocalDateTime.now());
            this.depressionMarkResultRepository.save(dmr);
        }
    }

    private List<DepressionMarkDTO> formDepressionMark(List<DepressionMark> depressionMarks){
        List<DepressionMarkDTO> depressionMarksDTO = new ArrayList<>();
        for(DepressionMark dm: depressionMarks) {
            depressionMarksDTO.add(new DepressionMarkDTO(dm.getUser().getId(), dm.getText()));
        }
        return depressionMarksDTO;
    }
    private void deleteFactHandles(List<FactHandle> factHandles){
        for (FactHandle fc : factHandles) {
            kieSession.delete(fc);
        }
    }


    private KieSession createSession(boolean start) throws IOException {

        String template1S = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\template.drt";
        InputStream template = new FileInputStream(template1S);

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(this.templateRules, template);

        System.out.println(drl);
        this.savedDrl = drl;
        return this.createKieSessionFromDRL(start);
    }

    private KieSession createKieSessionFromDRL(boolean start) throws IOException {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(this.savedDrl, ResourceType.DRL);
        //  kieHelper.addContent(drl2, ResourceType.DRL);
        String path = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\r1.drl";
        InputStream r1 = new FileInputStream(path);
        String r1S = convertInputStreamToString(r1);
        kieHelper.addContent(r1S, ResourceType.DRL);

        String path2 = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\backward.drl";
        InputStream r2 = new FileInputStream(path2);
        String r2S = convertInputStreamToString(r2);
        kieHelper.addContent(r2S, ResourceType.DRL);

        System.out.println(" CONTENT");
        System.out.println(savedDrl);
        System.out.println(r1S);
        System.out.println(r2S);
        Results results;
        KieSession newKieSession;
        if (start) {
            results = kieHelper.verify();
            newKieSession = kieHelper.build().newKieSession();
        }
        else{
            for(String p : this.paths){
                InputStream inputStream = new FileInputStream(p);
                String content = convertInputStreamToString(inputStream);
                System.out.println(content);
                kieHelper.addContent(content, ResourceType.DRL);
            }
            results = kieHelper.verify();
            // premestanje objekata
            newKieSession = kieHelper.build().newKieSession();
            newKieSession = this.moveObjectsToNewSession(newKieSession);
        }

        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)) {
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: " + message.getText());
            }
            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        return newKieSession;
    }

    public String makeNewRules(RuleDTO ruleDTO) throws IOException {

        int randomNumber = getRandomNumber();

        String generatedRule = "$u: User($uId: id)\n";
        for(RuleParamDTO ruleParamDTO: ruleDTO.getRuleParams()){
            int index = ruleDTO.getRuleParams().indexOf(ruleParamDTO);
            generatedRule += "$a"+index+": FullAnswer(user.id==$uId, question.id=="+ruleParamDTO.getQuestionId()+", score"+ruleParamDTO.getRelation()+ ruleParamDTO.getValue()+")\n";
        }

        String dynamicDrl = "package diagnostics;\n" +
                "import com.ftn.sbnz.model.helper.FullAnswer;\n"+
                "import com.ftn.sbnz.model.helper.DepressionMark;\n"+
                "import com.ftn.sbnz.model.Question;\n" +
                "rule \"MyRule" + randomNumber + "\"\n" +
                "agenda-group \"depression-mark\"\n"+
                "when\n" +

                generatedRule +

                "then\n" +
                "      insert(new DepressionMark($u, \"" + ruleDTO.getMessage()+ "\" ));\n" +
                "      System.out.println(\" fired depression rule \");" +
                "end";


        String path = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\dynamic_" + randomNumber +".drl";
        File newFile = new File(path);
        boolean success = newFile.createNewFile();
        FileWriter fileWriter = new FileWriter(path);

        // Write content to the file
        fileWriter.write(dynamicDrl);

        // Close the FileWriter
        fileWriter.close();
        this.paths.add(path);

        this.kieSession = createKieSessionFromDRL(false);
        return path;
    }

    private int getRandomNumber(){
        // Generate random integers in range 0 to 9999
        return rand.nextInt(10000);
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        scanner.close();
        return result;
    }


    public void addTemplateRules(List<TemplateParamDTO> templateParamDTOs) throws IOException {
        //  ovde nastavi dadjeee back dodavanje pravila ya template
        for(TemplateParamDTO dto: templateParamDTOs){
            DiagnosticTemplate diagnosticTemplate =   new DiagnosticTemplate();
            diagnosticTemplate.setType(dto.getDetection());
            diagnosticTemplate.setLayer(dto.getLayer());
            diagnosticTemplate.setIntensity(dto.getIntensity());
            diagnosticTemplate.setMin(dto.getMin());
            diagnosticTemplate.setMax(dto.getMax());
            diagnosticTemplate.setFinalResult(dto.getFinalResult());
            diagnosticTemplate.setText(dto.getText());
            this.templateRules.add(diagnosticTemplateService.save(diagnosticTemplate));
        }
        System.out.println("len: " + this.templateRules.size());
        this.kieSession = this.createSession(false);
    }

    //  sredi premestanje objekata iz stare u novu sesiju
    private KieSession moveObjectsToNewSession(KieSession newKieSession){
        Collection<Object> insertedObjects = (Collection<Object>) this.kieSession.getObjects();
        for(Object o : insertedObjects){
            newKieSession.insert(o);
        }
        return newKieSession;
    }


//    private void createTemplateRules() {
//        List<DiagnosticTemplate> templates = this.diagnosticTemplateService.getAll();
//        this.templateRules.addAll(templates);
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_ANKSIOZNOST", "FIRST", "BLAGO", 1, 7, true, "Nemate uslova za anksioznost. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_ANKSIOZNOST", "FIRST", "UMERENO", 8, 14, true, "Nemate uslova za anksioznost. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_ANKSIOZNOST", "FIRST", "IZRAZENO", 15, 19, true, "Nemate uslova za anksioznost. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_ANKSIOZNOST", "FIRST", "TESKO", 20, 26, false, "Primećeni su uslovi za anksioznost. Naredni set pitanja će sadržati i pitanja o anksioznosti."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_ANKSIOZNOST", "FIRST", "DUBOKO", 27, 30, false, "Primećeni su uslovi za anksioznost. Naredni set pitanja će sadržati i pitanja o anksioznosti."));
//
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_PANICNI_NAPAD", "FIRST", "BLAGO", 1, 7, true, "Nemate uslova za panični napad. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_PANICNI_NAPAD", "FIRST", "UMERENO", 8, 14, true, "Nemate uslova za panični napad. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_PANICNI_NAPAD", "FIRST", "IZRAZENO", 15, 19, true, "Nemate uslova za panični napad. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_PANICNI_NAPAD", "FIRST", "TESKO", 20, 26, false, "Primećeni su uslovi za panični napad. Naredni set pitanja će sadržati i pitanja o paničnom napadu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_PANICNI_NAPAD", "FIRST", "DUBOKO", 27, 30, false, "Primećeni su uslovi za panični napad. Naredni set pitanja će sadržati i pitanja o paničnom napadu."));
//
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_SOCIJALNU_ANKSIOZNOST", "FIRST", "BLAGO", 1, 7, true, "Nemate uslova za socijalnu anksioznost. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_SOCIJALNU_ANKSIOZNOST", "FIRST", "UMERENO", 8, 14, true, "Nemate uslova za socijalnu anksioznost. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_SOCIJALNU_ANKSIOZNOST", "FIRST", "IZRAZENO", 15, 19, true, "Nemate uslova za socijalnu anksioznost. Nemate razloga za brigu."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_SOCIJALNU_ANKSIOZNOST", "FIRST", "TESKO", 20, 26, false, "Primećeni su uslovi za socijalnu anksioznost. Naredni set pitanja će sadržati i pitanja o socijalnoj anksioznosti."));
//        this.templateRules.add(new DiagnosticTemplate("USLOVI_ZA_SOCIJALNU_ANKSIOZNOST", "FIRST", "DUBOKO", 27, 30, false, "Primećeni su uslovi za socijalnu anksioznost. Naredni set pitanja će sadržati i pitanja o socijalnoj anksioznosti."));
//
//        this.templateRules.add(new DiagnosticTemplate("ANKSIOZNOST", "SECOND", "BLAGO", 1, 30, true, "Detektovana je blaga anksioznost."));
//        this.templateRules.add(new DiagnosticTemplate("ANKSIOZNOST", "SECOND", "UMERENO", 31, 61, true, "Detektovana je umerena anksioznost."));
//        this.templateRules.add(new DiagnosticTemplate("ANKSIOZNOST", "SECOND", "IZRAZENO", 62, 82, true, "Detektovana je izražena anksioznost koja nije u domenu patologije."));
//        this.templateRules.add(new DiagnosticTemplate("ANKSIOZNOST", "SECOND", "TESKO", 83, 114, false, "Dijagnostikovana je anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o generalnom anksioznom poremećaju."));
//        this.templateRules.add(new DiagnosticTemplate("ANKSIOZNOST", "SECOND", "DUBOKO", 115, 130, false, "Dijagnostikovana je anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o generalnom anksioznom poremećaju."));
//
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_NAPAD", "SECOND", "BLAGO", 1, 10, true, "Vaša panika je blaga."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_NAPAD", "SECOND", "UMERENO", 11, 21, true, "Vaša panika je umerena."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_NAPAD", "SECOND", "IZRAZENO", 22, 28, true, "Vaša panika je izražena i nije u domenu patologije."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_NAPAD", "SECOND", "TESKO", 29, 39, false, "Dijagnostikovan je panični napad i naredni set pitanja će sadržati pitanja o paničnom poremećaju."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_NAPAD", "SECOND", "DUBOKO", 40, 45, false, "Dijagnostikovan je panični napad i naredni set pitanja će sadržati pitanja o paničnom poremećaju."));
//
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_ANKSIOZNOST", "SECOND", "BLAGO", 1, 9, true, "Detektovana je blaga socijalna anksioznost."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_ANKSIOZNOST", "SECOND", "UMERENO", 10, 18, true, "Detektovana je umerena socijalna anksioznost."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_ANKSIOZNOST", "SECOND", "IZRAZENO", 19, 25, true, "Detektovana je izražena socijalna anksioznost koja nije u domenu patologije."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_ANKSIOZNOST", "SECOND", "TESKO", 26, 35, false, "Dijagnostikovana je socijalna anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o socijalnoj fobiji."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_ANKSIOZNOST", "SECOND", "DUBOKO", 36, 40, false, "Dijagnostikovana je socijalna anksioznost visokog stepena i naredni set pitanja će sadržati pitanja o socijalnoj fobiji."));
//
//        this.templateRules.add(new DiagnosticTemplate("GENERALNI_ANKSIOZNI_POREMECAJ", "THIRD", "BLAGO", 1, 13, true, "Nemate naznake generalnog anksioznog poremećaja."));
//        this.templateRules.add(new DiagnosticTemplate("GENERALNI_ANKSIOZNI_POREMECAJ", "THIRD", "UMERENO", 14, 28, true, "Nemate naznake generalnog anksioznog poremećaja."));
//        this.templateRules.add(new DiagnosticTemplate("GENERALNI_ANKSIOZNI_POREMECAJ", "THIRD", "IZRAZENO", 29, 37, true, "Nemate naznake generalnog anksioznog poremećaja."));
//        this.templateRules.add(new DiagnosticTemplate("GENERALNI_ANKSIOZNI_POREMECAJ", "THIRD", "TESKO", 38, 52, false, "Dijagnostikovan je generalni anksiozni poremećaj."));
//        this.templateRules.add(new DiagnosticTemplate("GENERALNI_ANKSIOZNI_POREMECAJ", "THIRD", "DUBOKO", 53, 60, false, "Dijagnostikovan je generalni anksiozni poremećaj."));
//
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_POREMECAJ", "THIRD", "BLAGO", 1, 13, true, "Nemate naznake paničnog poremećaja."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_POREMECAJ", "THIRD", "UMERENO", 14, 28, true, "Nemate naznake paničnog poremećaja."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_POREMECAJ", "THIRD", "IZRAZENO", 29, 37, true, "Nemate naznake paničnog poremećaja."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_POREMECAJ", "THIRD", "TESKO", 38, 52, false, "Dijagnostikovan je panični poremećaj."));
//        this.templateRules.add(new DiagnosticTemplate("PANICNI_POREMECAJ", "THIRD", "DUBOKO", 53, 60, false, "Dijagnostikovan je panični poremećaj."));
//
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_FOBIJA", "THIRD", "BLAGO", 1, 11, true, "Nemate naznake socijalne fobije."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_FOBIJA", "THIRD", "UMERENO", 12, 23, true, "Nemate naznake socijalne fobije."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_FOBIJA", "THIRD", "IZRAZENO", 24, 31, true, "Nemate naznake socijalne fobije."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_FOBIJA", "THIRD", "TESKO", 32, 44, false, "Dijagnostikovana je socijalna fobija."));
//        this.templateRules.add(new DiagnosticTemplate("SOCIJALNA_FOBIJA", "THIRD", "DUBOKO", 45, 50, false, "Dijagnostikovana je socijalna fobija."));
//
// }
}
