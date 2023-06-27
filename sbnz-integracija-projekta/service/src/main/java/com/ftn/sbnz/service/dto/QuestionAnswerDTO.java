package com.ftn.sbnz.service.dto;

import com.ftn.sbnz.model.Answer;
import com.ftn.sbnz.model.DetectionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO {
    private String text;
    private int score;

    public QuestionAnswerDTO(Answer a) {
        this.score = a.getScore();
        this.text = a.getQuestion().getText();
    }
}
