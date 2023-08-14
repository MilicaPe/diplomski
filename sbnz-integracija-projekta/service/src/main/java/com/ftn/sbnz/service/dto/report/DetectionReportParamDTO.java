package com.ftn.sbnz.service.dto.report;

import com.ftn.sbnz.model.DetectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetectionReportParamDTO {
    private String detection;
    private String startDate;
    private String endDate;
}
