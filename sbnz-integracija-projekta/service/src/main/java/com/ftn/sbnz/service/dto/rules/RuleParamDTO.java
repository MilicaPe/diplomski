package com.ftn.sbnz.service.dto.rules;

import lombok.Data;

@Data
public class RuleParamDTO {
    private long questionId;
    private String relation;
    private String value;
}
