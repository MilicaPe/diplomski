package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.model.helper.DepressionMark;
import com.ftn.sbnz.model.helper.Diagnostic;
import com.ftn.sbnz.model.helper.DiagnosticState;
import com.ftn.sbnz.service.dto.AnswerDTO;
import com.ftn.sbnz.model.helper.FullAnswer;
import com.ftn.sbnz.service.dto.DepressionMarkDTO;
import com.ftn.sbnz.service.dto.ResultDTO;
import com.ftn.sbnz.service.dto.rules.RuleDTO;
import com.ftn.sbnz.service.dto.rules.RuleParamDTO;
import com.ftn.sbnz.service.repository.DepressionMarkResultRepository;
import com.ftn.sbnz.service.repository.UserRepository;
import org.drools.decisiontable.ExternalSpreadsheetCompiler;
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


    private final KieContainer kieContainer;

    private KieSession kieSession;

    private String savedDrl;
    private List<String> paths;
    private Random rand;
    @Autowired
    public DiagnosticService(KieContainer kieContainer) throws IOException {
        this.kieContainer = kieContainer;
        this.kieSession = this.makeRules(true);
        this.rand = new Random();
        this.paths = new ArrayList<String>();
    }

    private KieSession makeRules(boolean start) throws IOException {

        String template1S = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\template.drt";
        String data1S = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\templateGood.xls";

        InputStream template1 = new FileInputStream(template1S);
        InputStream data1 = new FileInputStream(data1S);

        System.out.println(template1.toString());
        System.out.println(data1.toString());

        ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
        String drl1 = converter.compile(data1, template1, 2, 1);

        System.out.println(drl1);
        this.savedDrl = drl1;

        return this.createKieSessionFromDRL( start);
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
        System.out.println(r1S);
        Results results;
        if (start) {
            results = kieHelper.verify();
        }
        else{
            for(String p : this.paths){
                InputStream inputStream = new FileInputStream(p);
                String content = convertInputStreamToString(inputStream);
                System.out.println(content);
                kieHelper.addContent(content, ResourceType.DRL);
            }
            results = kieHelper.verify();
        }

        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)) {
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: " + message.getText());
            }

            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        return kieHelper.build().newKieSession();
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

    public ArrayList<String> back(DetectionType symptomType) {

        kieSession.insert(new DiagnosticState(DetectionType.USLOVI_ZA_ANKSIOZNOST, DetectionType.ANKSIOZNOST));
        kieSession.insert(new DiagnosticState(DetectionType.ANKSIOZNOST, DetectionType.GENERALNI_ANKSIOZNI_POREMECAJ));

        kieSession.insert(new DiagnosticState(DetectionType.USLOVI_ZA_PANICNI_NAPAD, DetectionType.PANICNI_NAPAD));
        kieSession.insert(new DiagnosticState(DetectionType.PANICNI_NAPAD, DetectionType.PANICNI_POREMECAJ));

        kieSession.insert(new DiagnosticState(DetectionType.USLOVI_ZA_SOCIJALNU_ANKSIOZNOST, DetectionType.SOCIJALNA_ANKSIOZNOST));
        kieSession.insert(new DiagnosticState(DetectionType.SOCIJALNA_ANKSIOZNOST, DetectionType.SOCIJALNA_FOBIJA));

        FactHandle symptom = kieSession.insert(symptomType);
        int fired = this.kieSession.fireAllRules();
        this.kieSession.delete(symptom);

        ArrayList<String> result = new ArrayList<>();
        Collection<Object> insertedObjects = (Collection<Object>) kieSession.getObjects();
        // Print the inserted objects
        for (Object insertedObject : insertedObjects) {
            System.out.println("Inserted Object: " + insertedObject);
            if (insertedObject instanceof DetectionType) {
                DetectionType s = (DetectionType) insertedObject;
                result.add(s.toString());
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
}
