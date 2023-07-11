package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Question;
import com.ftn.sbnz.model.QuestionLayer;
import com.ftn.sbnz.service.dto.QuestionDTO;
import com.ftn.sbnz.service.dto.QuestionParamDTO;
import com.ftn.sbnz.service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired DetectionTypeService detectionTypeService;

    public List<QuestionDTO> getQuestions(QuestionLayer questionLayer, List<String> detectionTypes){
        List<Question> questions = new ArrayList<>();
        for(String detectionType : detectionTypes){
            System.out.println(" det : " + detectionType);
            System.out.println(" ques layer: " + questionLayer);
            questions.addAll(this.questionRepository.getQuestionsByDetectionTypeAndQuestionLayer(detectionType, questionLayer));
        }
        List<QuestionDTO> questionDTOS = formQuestionDTO(questions);
        return questionDTOS;
    }

    private List<QuestionDTO> formQuestionDTO( List<Question> questions) {
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for(Question question: questions){
            questionDTOS.add(new QuestionDTO(question.getId(), question.getText()));
        }
        return questionDTOS;
    }

    public List<QuestionDTO> getDepressionQuestions() {
        List<Question> questions = this.questionRepository.getQuestionsByPositiveDepressionMark();
        return formQuestionDTO(questions);
    }

    public void addNew(List<QuestionParamDTO> questions) {
        List<Question> newQuestions = new ArrayList<>();
        for(QuestionParamDTO questionParamDTO: questions){
            Question q = new Question();
            q.setText(questionParamDTO.getText());
            q.setQuestionLayer(QuestionLayer.valueOf(questionParamDTO.getLayer()));
            q.setPositive(questionParamDTO.isPositive());
            q.setDepressionMark(questionParamDTO.isDepressionMark());
            q.setDetectionType(this.detectionTypeService.getDetectionType(questionParamDTO.getDetection()));
            newQuestions.add(q);
        }
        this.questionRepository.saveAll(newQuestions);
    }
}
