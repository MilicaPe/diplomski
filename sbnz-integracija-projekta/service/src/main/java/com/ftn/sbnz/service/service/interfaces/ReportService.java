package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.service.dto.EmotionHistoryDTO;
import com.ftn.sbnz.service.dto.report.DetectionReportDTO;
import com.ftn.sbnz.service.dto.report.JobReportDTO;
import com.ftn.sbnz.service.dto.report.JobReportParamDTO;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportService {
    List<EmotionHistoryDTO> getUsersDetections(long userId, PageRequest of);
    long getUsersDetections(long userId);
    List<JobReportDTO> getJobReport(JobReportParamDTO params);
    DetectionReportDTO getDetectionTimeReport(DetectionType detection, LocalDateTime start, LocalDateTime end);

}
