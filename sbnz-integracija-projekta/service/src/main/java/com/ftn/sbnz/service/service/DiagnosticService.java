package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.model.helper.Diagnostic;
import com.ftn.sbnz.model.helper.DiagnosticState;
import com.ftn.sbnz.model.helper.SymptomType;
import com.ftn.sbnz.service.dto.AnswerDTO;
import com.ftn.sbnz.model.helper.FullAnswer;
import com.ftn.sbnz.service.dto.QuestionAnswerDTO;
import com.ftn.sbnz.service.dto.ResultDTO;
import com.ftn.sbnz.service.repository.AnswerRepository;
import com.ftn.sbnz.service.repository.EmotionResultRepository;
import com.ftn.sbnz.service.repository.QuestionRepository;
import com.ftn.sbnz.service.repository.UserRepository;
import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class DiagnosticService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmotionResultRepository emotionResultRepository;

    private final KieContainer kieContainer;

    private final KieSession kieSession;

    @Autowired
    public DiagnosticService(KieContainer kieContainer) throws IOException {
        this.kieContainer = kieContainer;
        this.kieSession = this.makeRules();
    }

    public ResultDTO postAnswers(List<AnswerDTO> answers, String loggedInUser) throws IOException {
        User user = this.userRepository.findByEmail(loggedInUser);//answers.get(0).getUserId()).orElseThrow(() -> new RuntimeException());
        FactHandle userFactHandle = kieSession.insert(user);

        List<FactHandle> answerList = new ArrayList<>();
        DetectionType detectionType = null;
        QuestionLayer questionLayer = null;
        kieSession.insert(user);
        for (AnswerDTO answerDTO : answers) {
            Answer answer = this.saveAnswer(answerDTO, user);
            detectionType = answer.getQuestion().getDetectionType();
            questionLayer = answer.getQuestion().getQuestionLayer();

            FullAnswer fullAnswer = new FullAnswer(answer.getId(), answer.getUser(), answer.getQuestion(),
                    answerDTO.getScore(), answer.getQuestion().isPositive());
            FactHandle ansInsert = kieSession.insert(fullAnswer);
            answerList.add(ansInsert);
            kieSession.getAgenda().getAgendaGroup("transform-diagnostic").setFocus();
            kieSession.fireAllRules();
        }
        // System.out.println(fullAnswers);


        kieSession.getAgenda().getAgendaGroup("first-diagnostic").setFocus();
        int fired1 = kieSession.fireAllRules();
        kieSession.getAgenda().getAgendaGroup("result-diagnostic").setFocus();
        int fired2 = kieSession.fireAllRules();

        System.out.println("*********** fired first diagnostic: " + fired1 + "  fired result: " + fired2);
        for (FactHandle fc : answerList) {
            kieSession.delete(fc);
        }
        kieSession.delete(userFactHandle);
        ResultDTO result = this.analiseObjectsInSession(user.getId(), questionLayer);
        this.saveResult(result, user);
        this.deleteFinalResultFromSession();
        System.out.println("result: " + result);
        return result;
    }

    private void saveResult(ResultDTO result, User user) {
        for (Diagnostic diagnostic : result.getDiagnostics()) {
            this.emotionResultRepository.save(new EmotionResult(user, getDetectionTypeForResult(diagnostic.getQuestionLayer(),
                        diagnostic.getDetectionType()), LocalDateTime.now()));

        }
    }

    private DetectionType getDetectionTypeForResult(QuestionLayer layer, DetectionType detectionType) {
        if (layer == QuestionLayer.FIRST && detectionType == DetectionType.ANKSIOZNOST)
            return DetectionType.USLOVI_ZA_ANKSIOZNOST;
        else if (layer == QuestionLayer.SECOND && detectionType == DetectionType.ANKSIOZNOST)
            return DetectionType.ANKSIOZNOST;
        else if (layer == QuestionLayer.THIRD && detectionType == DetectionType.ANKSIOZNOST)
            return DetectionType.GENERALNI_ANKSIOZNI_POREMECAJ;
        else if (layer == QuestionLayer.FIRST && detectionType == DetectionType.PANICNI_NAPAD)
            return DetectionType.USLOVI_ZA_PANICNI_NAPAD;
        else if (layer == QuestionLayer.SECOND && detectionType == DetectionType.PANICNI_NAPAD)
            return DetectionType.PANICNI_NAPAD;
        else if (layer == QuestionLayer.THIRD && detectionType == DetectionType.PANICNI_NAPAD)
            return DetectionType.PANICNI_POREMECAJ;
        else if (layer == QuestionLayer.FIRST && detectionType == DetectionType.SOCIJALNA_ANKSIOZNOST)
            return DetectionType.USLOVI_ZA_SOCIJAlNU_ANKSIOZNOST;
        else if (layer == QuestionLayer.SECOND && detectionType == DetectionType.SOCIJALNA_ANKSIOZNOST)
            return DetectionType.SOCIJALNA_ANKSIOZNOST;
        else
            return DetectionType.SOCIJALNA_FOBIJA;
    }

    private ResultDTO analiseObjectsInSession(long userId, QuestionLayer questionLayer) {
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

    private Answer saveAnswer(AnswerDTO answerDTO, User user) {
        System.out.println("ans id:  " + answerDTO.getId() + "    SCORE : " + answerDTO.getScore());
        Question question = this.questionRepository.findById(answerDTO.getQuestionId()).orElseThrow(() -> new RuntimeException());
        Answer answer = new Answer();
        answer.setUser(user);
        answer.setTime(LocalDateTime.now());
        answer.setScore(answerDTO.getScore());
        answer.setQuestion(question);
        return this.answerRepository.save(answer);
    }


    private KieSession makeRules() throws IOException {

        String template1S = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\template.drt";
        String data1S = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\templateGood.xls";

        InputStream template1 = new FileInputStream(template1S);
        InputStream data1 = new FileInputStream(data1S);

        System.out.println(template1.toString());
        System.out.println(data1.toString());

        ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
        String drl1 = converter.compile(data1, template1, 2, 1);

        System.out.println(drl1);

        return this.createKieSessionFromDRL(drl1);
    }

    private KieSession createKieSessionFromDRL(String drl1) throws IOException {
//        String path = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\r1.drl";
//        InputStream r1 = new FileInputStream(path);
//        String r1S = convertInputStreamToString(r1);
//
//        String path2 = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\diagnostics\\backward.drl";
//        InputStream r2 = new FileInputStream(path2);
//        String r2S = convertInputStreamToString(r2);
//
//        Resource resource = ResourceFactory.newClassPathResource(path, DiagnosticService.class);
//        Resource resource2 = ResourceFactory.newClassPathResource(path2, DiagnosticService.class);
//
//
//        Resource dynamicResource = ResourceFactory.newByteArrayResource(drl1.getBytes())
//                .setResourceType(ResourceType.DRL);
//
//        KiePackage kiePackage = KnowledgeBuilderFactory.newKnowledgeBuilder()
//                .add(dynamicResource, ResourceType.DRL)
//                .add(resource, ResourceType.DRL)
//                .add(resource2, ResourceType.DRL)
//                .getKnowledgePackages()
//                .iterator()
//                .next();





        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl1, ResourceType.DRL);
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

        Results results = kieHelper.verify();

        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)) {
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: " + message.getText());
            }

            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }

        return kieHelper.build().newKieSession();
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        scanner.close();
        return result;
    }

    public ArrayList<String> back(SymptomType symptomType) {

        kieSession.insert(new DiagnosticState(SymptomType.USLOV_ANK, SymptomType.ANK));
        kieSession.insert(new DiagnosticState(SymptomType.ANK, SymptomType.GAD));

        kieSession.insert(new DiagnosticState(SymptomType.USLOV_PAN, SymptomType.PAN));
        kieSession.insert(new DiagnosticState(SymptomType.PAN, SymptomType.PAN_POR));

        kieSession.insert(new DiagnosticState(SymptomType.USLOV_SOC, SymptomType.SOC));
        kieSession.insert(new DiagnosticState(SymptomType.SOC, SymptomType.SOC_FOB));

        FactHandle symptom = kieSession.insert(symptomType);
        int fired = this.kieSession.fireAllRules();
        this.kieSession.delete(symptom);

        ArrayList<String> result = new ArrayList<>();
        Collection<Object> insertedObjects = (Collection<Object>) kieSession.getObjects();
        // Print the inserted objects
        for (Object insertedObject : insertedObjects) {
            System.out.println("Inserted Object: " + insertedObject);
            if (insertedObject instanceof SymptomType) {
                SymptomType s = (SymptomType)insertedObject;
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

    public List<QuestionAnswerDTO> getAnswers(long id) {
        EmotionResult emotionResult = this.emotionResultRepository.findById(id).orElse(null);
        User user = emotionResult.getUser();
        QuestionLayer layer = getLayerForRequest(emotionResult.getDetected());
        DetectionType detectionType = getDetectionTypeForRequest(emotionResult.getDetected());
        List<Answer> answers = this.answerRepository.findByUserIdAndTimeForDiagnostic(user.getId(), emotionResult.getTime().minusHours(3), emotionResult.getTime().plusHours(3), detectionType, layer);
        return convertToQuestionAnswerDTO(answers);
    }

    private DetectionType getDetectionTypeForRequest(DetectionType detectionType){
        switch (detectionType){
            case USLOVI_ZA_ANKSIOZNOST: return DetectionType.ANKSIOZNOST;
            case ANKSIOZNOST: return DetectionType.ANKSIOZNOST;
            case GENERALNI_ANKSIOZNI_POREMECAJ: return DetectionType.GENERALNI_ANKSIOZNI_POREMECAJ;
            case USLOVI_ZA_PANICNI_NAPAD: return DetectionType.PANICNI_NAPAD;
            case PANICNI_NAPAD: return DetectionType.PANICNI_NAPAD;
            case PANICNI_POREMECAJ: return DetectionType.PANICNI_NAPAD;
            case USLOVI_ZA_SOCIJAlNU_ANKSIOZNOST: return DetectionType.SOCIJALNA_ANKSIOZNOST;
            case SOCIJALNA_ANKSIOZNOST: return DetectionType.SOCIJALNA_ANKSIOZNOST;
            case SOCIJALNA_FOBIJA: return DetectionType.SOCIJALNA_ANKSIOZNOST;
            default:return detectionType;
        }
    }

    private QuestionLayer getLayerForRequest(DetectionType detectionType){
        switch (detectionType){
            case USLOVI_ZA_ANKSIOZNOST: return QuestionLayer.FIRST;
            case ANKSIOZNOST: return QuestionLayer.SECOND;
            case GENERALNI_ANKSIOZNI_POREMECAJ: return QuestionLayer.THIRD;
            case USLOVI_ZA_PANICNI_NAPAD: return QuestionLayer.FIRST;
            case PANICNI_NAPAD: return QuestionLayer.SECOND;
            case PANICNI_POREMECAJ: return QuestionLayer.THIRD;
            case USLOVI_ZA_SOCIJAlNU_ANKSIOZNOST: return QuestionLayer.FIRST;
            case SOCIJALNA_ANKSIOZNOST: return QuestionLayer.SECOND;
            case SOCIJALNA_FOBIJA: return QuestionLayer.THIRD;
            default: return QuestionLayer.FIRST;
        }
    }
    private List<QuestionAnswerDTO> convertToQuestionAnswerDTO(List<Answer> answers) {
        List<QuestionAnswerDTO> result = new ArrayList<>();
        for (Answer a : answers)
            result.add(new QuestionAnswerDTO(a));
        return result;
    }
}
