package com.ftn.sbnz.service.dto.rules;

import lombok.Data;

import java.util.List;

@Data
public class RuleDTO {
    private List<RuleParamDTO> ruleParams;
    private String message;
}
