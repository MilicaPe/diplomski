package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.EmotionResult;
import com.ftn.sbnz.model.Gender;
import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.EmotionHistoryDTO;
import com.ftn.sbnz.service.dto.report.DetectionReportDTO;
import com.ftn.sbnz.service.dto.report.DetectionReportParamDTO;
import com.ftn.sbnz.service.dto.report.JobReportDTO;
import com.ftn.sbnz.service.dto.report.JobReportParamDTO;
import com.ftn.sbnz.service.repository.EmotionResultRepository;
import com.ftn.sbnz.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class ReportService {
    @Autowired
    private EmotionResultRepository emotionResultRepository;

    @Autowired
    private UserRepository userRepository;

    public List<EmotionHistoryDTO> getUsersDetections(long userId, PageRequest of){
        List<EmotionResult> results= this.emotionResultRepository.findAllByUserId(userId, of);
        List<EmotionHistoryDTO> resultDTOS = new ArrayList<>();
        for(EmotionResult er: results){
            resultDTOS.add(new EmotionHistoryDTO(er));
        }
         return resultDTOS;
    }

    public long getUsersDetections(long userId){
        return this.emotionResultRepository.countByUserId(userId);
    }


    public List<JobReportDTO> getJobReport(JobReportParamDTO params) {
        List<User> users = filterUsers(params);
        List<EmotionResult> result = new ArrayList<>();
        for(User u :users){
            result.addAll(u.getEmotionResults());
        }
        return formJobReport(result);

    }

    private List<JobReportDTO> formJobReport(List<EmotionResult> result){
        Map<DetectionType, Integer> res = new HashMap<>();
        DetectionType keyValue = null;
        for(EmotionResult e: result){
            keyValue = e.getDetected();
            if (res.containsKey(keyValue)) {
                res.put(keyValue, (res.get(keyValue)+1));
            } else {
                System.out.println(keyValue);
                res.put(keyValue, 1);
            }
        }
        List<JobReportDTO> jobReportDTOS = new ArrayList<>();
        res.forEach((key, value) -> {
            // Perform operations using key and value
            System.out.println("Key: " + key + ", Value: " + value);
            jobReportDTOS.add(new JobReportDTO(key, value));
        });
        return jobReportDTOS;
    }

    private List<User>  filterUsers(JobReportParamDTO params){
        List<User> users =  new ArrayList<>();
        if(params.getGender().equals("ALL")){
            users.addAll(this.userRepository.findUsersByJobAAndGenderAndYearOfBirth(Gender.FEMALE, params.getJob(), params.getStartYear(), params.getEndYear()));
            users.addAll(this.userRepository.findUsersByJobAAndGenderAndYearOfBirth(Gender.MALE, params.getJob(), params.getStartYear(), params.getEndYear()));
        }else{
            users = this.userRepository.findUsersByJobAAndGenderAndYearOfBirth(Gender.valueOf(params.getGender()), params.getJob(), params.getStartYear(), params.getEndYear());
        }
        return users;
    }

    public DetectionReportDTO getDetectionTimeReport(DetectionType detection, LocalDateTime start, LocalDateTime end){
        List<EmotionResult> results = this.emotionResultRepository.findAllByDetectedAndTime(detection, start, end);
        return formDetectionReport(results);
      //  return null;
    }

    private DetectionReportDTO formDetectionReport (List<EmotionResult> result){
        Map<String, Integer> res = new HashMap<>();
        for(EmotionResult e: result){
            String keyValue = formDateString(e.getTime());
            if (res.containsKey(keyValue)) {
                res.put(keyValue, (res.get(keyValue)+1));
            } else {
                System.out.println(keyValue);
                res.put(keyValue, 1);
            }
        }
        List<String> keyList = new ArrayList<>(res.keySet());
        List<Integer> valueList = new ArrayList<>(res.values());
        return new DetectionReportDTO(valueList, keyList);

    }

    private String formDateString(LocalDateTime time){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDateTime = time.format(dateTimeFormatter);
        return formattedDateTime;
    }
}
