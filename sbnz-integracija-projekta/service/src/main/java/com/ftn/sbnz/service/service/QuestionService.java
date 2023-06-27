package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Question;
import com.ftn.sbnz.model.QuestionLayer;
import com.ftn.sbnz.service.dto.QuestionDTO;
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

    public List<QuestionDTO> getQuestions(QuestionLayer questionLayer, List<DetectionType> detectionTypes){
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for(DetectionType detectionType : detectionTypes){
            questions.addAll(this.questionRepository.getQuestionsByDetectionTypeAndQuestionLayer(detectionType, questionLayer));
        }
        for(Question question: questions){
            questionDTOS.add(new QuestionDTO(question.getId(), question.getText()));
        }
        return questionDTOS;
    }
}
