package com.ftn.sbnz.service.dto;

import com.ftn.sbnz.model.DetectionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuestionAnswerByEmotionDTO {
    private List<QuestionAnswerDTO> answers;
    private String emotion;

    public QuestionAnswerByEmotionDTO(List<QuestionAnswerDTO> result, String detectionType){
        this.answers = result;
        this.emotion = detectionType;
//        this.answers.add(resultSad);
//        this.answers.add(resultDisgusted);
//        this.answers.add(resultAngry);
//        this.answers.add(resultFearful);
//        this.answers.add(resultBad);
//        this.answers.add(resultSurprised);
//        this.answers.add(resultHappy);
    }
}
