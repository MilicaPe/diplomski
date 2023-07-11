package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionParamDTO {
    @NotBlank
    private String text;
    @NotBlank
    private String detection;
    @NotBlank
    private String layer;
    @NotBlank
    private boolean positive;
    @NotBlank
    private boolean depressionMark;

}