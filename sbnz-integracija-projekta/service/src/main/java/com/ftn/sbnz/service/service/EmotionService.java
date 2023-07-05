package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.model.dto.EmotionDetection;
import com.ftn.sbnz.service.dto.*;
import com.ftn.sbnz.service.repository.AnswerRepository;
import com.ftn.sbnz.service.repository.QuestionRepository;
import com.ftn.sbnz.service.repository.ResultRepository;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class EmotionService {

    private final KieContainer kieContainer;

    private KieSession kSession;

    @Autowired
    public EmotionService(KieContainer kieContainer) throws IOException {
        this.kieContainer = kieContainer;
        kSession = createTemplateKieSession();
    }

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResultRepository resultRepository;


    public EmotionResultDTO analyseSurvey(SurveyDTO answers, String loggedInUser) throws IOException {
        User user = userRepository.findByEmail(loggedInUser);
        FactHandle userFactHandle = kSession.insert(user);

        List<FactHandle> answerList = new ArrayList<>();

        LocalDateTime time = LocalDateTime.now();
        for (EmotionAnswerDTO a : answers.getAnswers()){
            Question q1 = questionRepository.findById(a.getQuestionId()).orElse(null);//new Question();
            Answer a1 = new Answer(user, q1, a.getScore(),time);
            Answer savedAnswer = answerRepository.save(a1);
            FactHandle ansInsert = kSession.insert(savedAnswer);
            answerList.add(ansInsert);
            kSession.getAgenda().getAgendaGroup("transform").setFocus();
            kSession.fireAllRules();
        }
        kSession.getAgenda().getAgendaGroup("first").setFocus();
        kSession.fireAllRules();
        kSession.getAgenda().getAgendaGroup("first-conclusion").setFocus();
        kSession.fireAllRules();
        kSession.getAgenda().getAgendaGroup("conclusion").setFocus();
        kSession.fireAllRules();


        for (FactHandle fc : answerList){
            kSession.delete(fc);
        }
        kSession.delete(userFactHandle);
//        System.out.println("****************************************************************");
        return new EmotionResultDTO(getResult(user, time));
    }

    private Result getResult(User user, LocalDateTime time){
        Collection<Object> insertedObjects = (Collection<Object>) kSession.getObjects();
        // Print the inserted objects
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        for (Object insertedObject : insertedObjects) {
            System.out.println("Inserted Object: " + insertedObject);
            if(insertedObject instanceof EmotionDetection){
                EmotionDetection newEmotion = (EmotionDetection) insertedObject;
                System.out.println(newEmotion.getIntensity());
                System.out.println(newEmotion.getQuestionLayer());
                System.out.println(newEmotion.getDetectionType());
                System.out.println(newEmotion.getTime());
//                kSession.delete(insertedObject);
                if(newEmotion.getUser().getId() == user.getId()){
                    Result emotionResult = new Result(user, newEmotion.getDetectionType(), time);
                    FactHandle factHandle = kSession.getFactHandle(insertedObject);
                    kSession.delete(factHandle);
                    return resultRepository.save(emotionResult);
                }
            }
        }
        System.out.println("---------------------------------------");
        return null;
    }

    public KieSession createTemplateKieSession() throws IOException {
        String drtFile = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\emotions\\template\\emotions-1.drt";
        String csvFile = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\emotions\\template\\emotions-1.xls";

        String drtFile2 = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\emotions\\template\\decision.drt";
        String csvFile2 = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\emotions\\template\\decision.xls";

        String firstPart = getDRLFileGenerated(drtFile, csvFile);
        String desicionPart = getDRLFileGenerated(drtFile2, csvFile2);


        return this.createKieSessionFromDRL(firstPart, desicionPart);
    }

    private String getDRLFileGenerated(String drtFile, String csvFile) throws FileNotFoundException {
        InputStream template = new FileInputStream(drtFile);

        InputStream data = new FileInputStream(csvFile);

        ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();
        String drl = converter.compile(data, template, 2, 1);
//        System.out.println("******************* TEMP *******************");
//        System.out.println(drl);
//        System.out.println("-------------------------------------------");
        return drl;
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        scanner.close();
        return result;
    }

    private KieSession createKieSessionFromDRL(String drl, String drl2) throws IOException {
        KieHelper kieHelper = new KieHelper();
        String transformFile = new File(".").getCanonicalPath() + "\\kjar\\src\\main\\resources\\rules\\emotions\\emotion-rules.drl";

        InputStream r1 = new FileInputStream(transformFile);
        String r1S = convertInputStreamToString(r1);
        kieHelper.addContent(r1S, ResourceType.DRL);

        kieHelper.addContent(drl, ResourceType.DRL);
        kieHelper.addContent(drl2, ResourceType.DRL);

        Results results = kieHelper.verify();

        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }

            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }

        return kieHelper.build().newKieSession();
    }

    public List<QuestionDTO> getQuestions() {
        List<QuestionDTO> questions = convertToQuestionDTO(questionRepository.findByDetectionType(DetectionType.SAD));
        questions.addAll(convertToQuestionDTO(questionRepository.findByDetectionType(DetectionType.DISGUSTED)));
        questions.addAll(convertToQuestionDTO(questionRepository.findByDetectionType(DetectionType.ANGRY)));
        questions.addAll(convertToQuestionDTO(questionRepository.findByDetectionType(DetectionType.FEARFUL)));
        questions.addAll(convertToQuestionDTO(questionRepository.findByDetectionType(DetectionType.BAD)));
        questions.addAll(convertToQuestionDTO(questionRepository.findByDetectionType(DetectionType.SURPRISED)));
        questions.addAll(convertToQuestionDTO(questionRepository.findByDetectionType(DetectionType.HAPPY)));
        return questions;
    }

    private List<QuestionDTO> convertToQuestionDTO(List<Question> questionList) {
        List<QuestionDTO> result = new ArrayList<>();
        for (Question q : questionList){
            result.add(new QuestionDTO(q.getId(), q.getText()));
        }
        return result;
    }

    public List<EmotionHistoryDTO> getAllEmotions(PageRequest of, String loggedInUser) {
//        User user = this.userRepository.findByEmail(loggedInUser);
        return convertToEmotionHistoryDTO(this.resultRepository.findByEmail(loggedInUser, of));
    }

    private List<EmotionHistoryDTO> convertToEmotionHistoryDTO(List<Result> emotionResultList) {
        List<EmotionHistoryDTO> result = new ArrayList<>();
        for (Result emotionResult: emotionResultList){
            result.add(new EmotionHistoryDTO(emotionResult));
        }
        return result;
    }

    public long getEmotionHistoryCount(String loggedInUser) {
        return this.resultRepository.countByUserEmail(loggedInUser);
    }

    public List<QuestionAnswerByEmotionDTO> getAnswers(long id) {
        Result emotionResult = this.resultRepository.findById(id).orElse(null);
        User user = emotionResult.getUser();
        List<Answer> answers = this.answerRepository.findByUserIdAndTime(user.getId(), emotionResult.getTime());
        return convertToQuestionAnswerDTO(answers);
    }

    private List<QuestionAnswerByEmotionDTO> convertToQuestionAnswerDTO(List<Answer> answers) {
        List<QuestionAnswerDTO> resultSad = new ArrayList<>();
        List<QuestionAnswerDTO> resultDisgusted = new ArrayList<>();
        List<QuestionAnswerDTO> resultAngry = new ArrayList<>();
        List<QuestionAnswerDTO> resultFearful = new ArrayList<>();
        List<QuestionAnswerDTO> resultBad = new ArrayList<>();
        List<QuestionAnswerDTO> resultSurprised = new ArrayList<>();
        List<QuestionAnswerDTO> resultHappy= new ArrayList<>();
        for (Answer a: answers){
            switch (a.getQuestion().getDetectionType()){
                case SAD: resultSad.add(new QuestionAnswerDTO(a)); break;
                case DISGUSTED: resultDisgusted.add(new QuestionAnswerDTO(a)); break;
                case ANGRY: resultAngry.add(new QuestionAnswerDTO(a)); break;
                case FEARFUL: resultFearful.add(new QuestionAnswerDTO(a)); break;
                case BAD: resultBad.add(new QuestionAnswerDTO(a)); break;
                case SURPRISED: resultSurprised.add(new QuestionAnswerDTO(a)); break;
                case HAPPY: resultHappy.add(new QuestionAnswerDTO(a)); break;
                default: break;
            }
//            result.add();
        }
        List<QuestionAnswerByEmotionDTO> result = new ArrayList<>();
        result.add(new QuestionAnswerByEmotionDTO(resultSad, DetectionType.SAD));
        result.add(new QuestionAnswerByEmotionDTO(resultAngry, DetectionType.ANGRY));
        result.add(new QuestionAnswerByEmotionDTO(resultBad, DetectionType.BAD));
        result.add(new QuestionAnswerByEmotionDTO(resultHappy, DetectionType.HAPPY));
        result.add(new QuestionAnswerByEmotionDTO(resultDisgusted, DetectionType.DISGUSTED));
        result.add(new QuestionAnswerByEmotionDTO(resultFearful, DetectionType.FEARFUL));
        result.add(new QuestionAnswerByEmotionDTO(resultSurprised, DetectionType.SURPRISED));

        return result;
    }
}
