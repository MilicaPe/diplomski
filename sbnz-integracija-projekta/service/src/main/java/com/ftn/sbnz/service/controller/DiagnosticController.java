package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.helper.SymptomType;
import com.ftn.sbnz.service.dto.AnswerDTO;
import com.ftn.sbnz.service.dto.QuestionAnswerDTO;
import com.ftn.sbnz.service.dto.ResultDTO;
import com.ftn.sbnz.service.service.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class DiagnosticController {
    @Autowired
    private DiagnosticService answerService;


    @PostMapping(value="answer/post")
    @PreAuthorize("hasAuthority('diagnostic_answer_post')")
    public ResponseEntity<ResultDTO> postAnswers(@RequestBody List<AnswerDTO> answers) throws IOException {
        String loggedInUser = getLoggedInUser();
        return new ResponseEntity<>(this.answerService.postAnswers(answers, loggedInUser), HttpStatus.OK);
    }

    @GetMapping(value="answer/get/sym/{symptom}")
    @PreAuthorize("hasAuthority('diagnostic_answer_get')")
    public ResponseEntity<List<String>> back(@PathVariable SymptomType symptom){
        return new ResponseEntity<>(this.answerService.back(symptom), HttpStatus.OK);
    }

    @GetMapping(value="answer/get/{id}")
    @PreAuthorize("hasAuthority('diagnostic_answer_get_id')")
    public ResponseEntity<List<QuestionAnswerDTO>> getAnswers(@PathVariable long id){
        return new ResponseEntity<>(this.answerService.getAnswers(id), HttpStatus.OK);
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
