package com.ftn.sbnz.service.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetectionReportDTO {
    private List<Integer> count;
    private List<String> date;

}
