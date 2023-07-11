package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.model.helper.Diagnostic;
import com.ftn.sbnz.service.dto.QuestionAnswerDTO;
import com.ftn.sbnz.service.dto.ResultDTO;
import com.ftn.sbnz.service.repository.AnswerRepository;
import com.ftn.sbnz.service.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private AnswerRepository answerRepository;


    public void saveResult(ResultDTO result, User user) {
        for (Diagnostic diagnostic : result.getDiagnostics()) {
            this.resultRepository.save(new Result(user, diagnostic.getDetectionType(), LocalDateTime.now()));

        }
    }

    public List<QuestionAnswerDTO> getResultAnswers(long id) {
        Result result = this.resultRepository.findById(id).orElse(null);
        User user = result.getUser();
        QuestionLayer layer = getLayerForRequest(result.getDetected());
        String detectionType = result.getDetected();
        List<Answer> answers = this.answerRepository.findByUserIdAndTimeForDiagnostic(user.getId(), result.getTime().minusHours(3), result.getTime().plusHours(3), detectionType, layer);
        return convertToQuestionAnswerDTO(answers);
    }

    private List<QuestionAnswerDTO> convertToQuestionAnswerDTO(List<Answer> answers) {
        List<QuestionAnswerDTO> result = new ArrayList<>();
        for (Answer a : answers)
            result.add(new QuestionAnswerDTO(a));
        return result;
    }

    private QuestionLayer getLayerForRequest(String detectionType){
        switch (detectionType){
            case "USLOVI_ZA_ANKSIOZNOST": return QuestionLayer.FIRST;
            case "ANKSIOZNOST": return QuestionLayer.SECOND;
            case "GENERALNI_ANKSIOZNI_POREMECAJ": return QuestionLayer.THIRD;
            case "USLOVI_ZA_PANICNI_NAPAD": return QuestionLayer.FIRST;
            case "PANICNI_NAPAD": return QuestionLayer.SECOND;
            case "PANICNI_POREMECAJ": return QuestionLayer.THIRD;
            case "USLOVI_ZA_SOCIJALNU_ANKSIOZNOST": return QuestionLayer.FIRST;
            case "SOCIJALNA_ANKSIOZNOST": return QuestionLayer.SECOND;
            case "SOCIJALNA_FOBIJA": return QuestionLayer.THIRD;
            default: return QuestionLayer.FIRST;
        }
    }
}
