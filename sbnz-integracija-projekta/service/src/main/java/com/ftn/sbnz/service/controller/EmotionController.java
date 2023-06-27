package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.service.dto.*;
import com.ftn.sbnz.service.service.EmotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "emotions/", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmotionController {

    @Autowired
    private EmotionService emotionService;

    @PostMapping("survey")
    @PreAuthorize("hasAuthority('emotion_survey')")
    public ResponseEntity<EmotionResultDTO> test(@RequestBody SurveyDTO answers) throws IOException {
        String loggedInUser = getLoggedInUser();
        return new ResponseEntity<>(this.emotionService.analyseSurvey(answers, loggedInUser), HttpStatus.OK)  ;
    }


    @GetMapping("5")
    @PreAuthorize("hasAuthority('emotion5')")
    public void testLogin() throws IOException {
        System.out.println("WORKSSSSSSSSSSSSSSSSSSSSSSS");
    }

    @GetMapping("questions")
    @PreAuthorize("hasAuthority('emotion_questions')")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        return new ResponseEntity<>(this.emotionService.getQuestions(), HttpStatus.OK);
    }

    @GetMapping("results/{page}/{row}")
    @PreAuthorize("hasAuthority('emotion_history')")
    public ResponseEntity<PaginationDTO<EmotionHistoryDTO>> getEmotionHistory(@PathVariable int page, @PathVariable int row){
        String loggedInUser = getLoggedInUser();
        List<EmotionHistoryDTO> resultList = new ArrayList<>();
        PaginationDTO<EmotionHistoryDTO> result = new PaginationDTO<>(0, resultList);
        resultList = emotionService.getAllEmotions(PageRequest.of(page, row), loggedInUser);//.subList(page, row);
        result.setTotalCount(emotionService.getEmotionHistoryCount(loggedInUser));
        result.setResultList(resultList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("answers/{id}")
    @PreAuthorize("hasAuthority('emotion_answers')")
    public ResponseEntity<?> test(@PathVariable long id) throws IOException {
        return new ResponseEntity<>(this.emotionService.getAnswers(id), HttpStatus.OK)  ;
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
