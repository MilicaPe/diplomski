package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateParamDTO {
    private String detection;
    private int min;
    private int max;
    private String intensity;
    private String layer;
    private Boolean finalResult;
    private String text;
}
