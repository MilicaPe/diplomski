package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private long id;
    private String text;
/*
    private String questionLayer;
    private String detectionType;
    private boolean positive;
*/
}
