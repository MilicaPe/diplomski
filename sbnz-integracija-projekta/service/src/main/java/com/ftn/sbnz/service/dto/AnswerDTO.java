package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private long id;
    private long userId;
    private long questionId;
    private int score;
    private LocalDateTime time;
}