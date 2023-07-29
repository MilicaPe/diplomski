package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.model.QuestionLayer;
import com.ftn.sbnz.service.dto.QuestionDTO;
import com.ftn.sbnz.service.dto.QuestionParamDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getQuestions(QuestionLayer questionLayer, List<String> detectionTypes);
    List<QuestionDTO> getDepressionQuestions();
    void addNewQuestion(List<QuestionParamDTO> questions);

}
