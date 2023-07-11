package com.ftn.sbnz.service.dto.report;

import com.ftn.sbnz.model.DetectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.rule.All;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobReportDTO {
    private String detectionType;
    private int count;
}
