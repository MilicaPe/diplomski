package com.ftn.sbnz.service.controller;


import com.ftn.sbnz.service.dto.EmotionHistoryDTO;
import com.ftn.sbnz.service.dto.PaginationDTO;
import com.ftn.sbnz.service.dto.report.DetectionReportDTO;
import com.ftn.sbnz.service.dto.report.DetectionReportParamDTO;
import com.ftn.sbnz.service.dto.report.JobReportDTO;
import com.ftn.sbnz.service.dto.report.JobReportParamDTO;
import com.ftn.sbnz.service.service.ReportService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping(value = "user/{userId}/{page}/{row}")
    @PreAuthorize("hasAuthority('report_user')")
    public ResponseEntity<PaginationDTO<EmotionHistoryDTO>> getReportForClient(@PathVariable long userId,@PathVariable int page, @PathVariable int row){
        System.out.println("userId : " + userId + "  page:  " + page + "  row: " + row);
        List<EmotionHistoryDTO> historyDTOS = this.reportService.getUsersDetections(userId, PageRequest.of(page, row));
        PaginationDTO<EmotionHistoryDTO> paginationDTO= new PaginationDTO<>();
        paginationDTO.setResultList(historyDTOS);
        paginationDTO.setTotalCount(this.reportService.getUsersDetections(userId));
        return new ResponseEntity<>(paginationDTO, HttpStatus.OK);
    }

    @PostMapping(value = "job/age/gender")
    @PreAuthorize("hasAuthority('report_job')")
    public ResponseEntity<List<JobReportDTO>> getReportForJobAge(@RequestBody JobReportParamDTO params){
        List<JobReportDTO> report = this.reportService.getJobReport(params);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

    @PostMapping(value="detection")
    @PreAuthorize("hasAuthority('report_detection')")
    public ResponseEntity<DetectionReportDTO> getDetectionReport(@RequestBody DetectionReportParamDTO detectionReportParamDTO){

        System.out.println(detectionReportParamDTO.getDetection() + "  " + detectionReportParamDTO.getStartDate() + "  " + detectionReportParamDTO.getEndDate());
        LocalDateTime startDate = getDateTime(detectionReportParamDTO.getStartDate());
        LocalDateTime endDate = getDateTime(detectionReportParamDTO.getEndDate());

        DetectionReportDTO detectionReportDTO = this.reportService.getDetectionTimeReport(detectionReportParamDTO.getDetection(), startDate, endDate);

        return new ResponseEntity(detectionReportDTO, HttpStatus.OK);
    }

    private LocalDateTime getDateTime(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datePart = dateStr.trim().split("T")[0];
        datePart+=" 00:00:00";
        LocalDateTime date = LocalDateTime.parse(datePart, formatter);
        return date.plusDays(1);
    }
}
