package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.QuestionLayer;
import com.ftn.sbnz.service.dto.PaginationDTO;
import com.ftn.sbnz.service.dto.QuestionDTO;
import com.ftn.sbnz.service.dto.QuestionParamDTO;
import com.ftn.sbnz.service.repository.DetectionTypeRepository;
import com.ftn.sbnz.service.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private DetectionTypeRepository detectionTypeRepository;

    @PostMapping(value = "question/{layer}")
    @PreAuthorize("hasAuthority('question_get')")
    public ResponseEntity<PaginationDTO<QuestionDTO>> getQuestions(@PathVariable String layer, @RequestBody List<String> types){

        QuestionLayer nextLayer = QuestionLayer.valueOf(layer);
//        List<DetectionType> detectionTypes = new ArrayList<>();
//        String[] typeList = type.trim().split(" ");
//        for(String part: typeList){
//            detectionTypes.add(this.detectionTypeRepository.getDetectionTypeByType(part));
//        }

        List<QuestionDTO> questionDTOS = this.questionService.getQuestions(nextLayer, types);
        PaginationDTO<QuestionDTO> paginationDTO = new PaginationDTO<>(questionDTOS.size(), questionDTOS);
        return new ResponseEntity<>(paginationDTO, HttpStatus.OK);
    }

    @GetMapping(value="question/depression")
    public ResponseEntity<List<QuestionDTO>>getQuestionsMarkDepression(){
        List<QuestionDTO> questionDTOS = this.questionService.getDepressionQuestions();
        return new ResponseEntity<>(questionDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "question/add")
    public ResponseEntity<?> addNewQuestions(@RequestBody @Valid List<QuestionParamDTO> questions){
        System.out.println("////// add question /////");
        this.questionService.addNewQuestion(questions);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
