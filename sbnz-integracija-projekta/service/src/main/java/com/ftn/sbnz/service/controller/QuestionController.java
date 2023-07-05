package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.QuestionLayer;
import com.ftn.sbnz.service.dto.PaginationDTO;
import com.ftn.sbnz.service.dto.QuestionDTO;
import com.ftn.sbnz.service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "question/{layer}/{type}")
    @PreAuthorize("hasAuthority('question_get')")
    public ResponseEntity<PaginationDTO<QuestionDTO>> getQuestions(@PathVariable String layer, @PathVariable String type){

        QuestionLayer nextLayer = QuestionLayer.valueOf(layer);
        List<DetectionType> detectionTypes = new ArrayList<>();
        String[] typeList = type.trim().split(" ");
        for(String part: typeList){
            detectionTypes.add(DetectionType.valueOf(part));
        }

        List<QuestionDTO> questionDTOS = this.questionService.getQuestions(nextLayer, detectionTypes);
        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO<>(questionDTOS.size(), questionDTOS);
        return new ResponseEntity<>(paginationDTO, HttpStatus.OK);
    }

    @GetMapping(value="question/depression")
    public ResponseEntity<List<QuestionDTO>>getQuestionsMarkDepression(){
        List<QuestionDTO> questionDTOS = this.questionService.getDepressionQuestions();
        return new ResponseEntity<>(questionDTOS, HttpStatus.OK);
    }
}
