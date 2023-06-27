package com.ftn.sbnz.service.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.rule.All;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobReportParamDTO {
    private int startYear;
    private int endYear;
    private String job;
    private String gender;
}
