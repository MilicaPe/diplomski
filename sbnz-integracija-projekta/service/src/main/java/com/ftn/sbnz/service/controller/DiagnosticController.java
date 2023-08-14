package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.DiagnosticTemplate;
import com.ftn.sbnz.service.dto.*;
import com.ftn.sbnz.service.dto.rules.RuleDTO;
import com.ftn.sbnz.service.service.ResultServiceImpl;
import com.ftn.sbnz.service.service.interfaces.DiagnosticService;
import com.ftn.sbnz.service.service.interfaces.DiagnosticTemplateService;
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
    private DiagnosticService diagnosticService;

    @Autowired
    private ResultServiceImpl resultService;


    @PostMapping(value="diagnostic/survey")
    @PreAuthorize("hasAuthority('diagnostic_answer_post')")
    public ResponseEntity<ResultDTO> postAnswers(@RequestBody List<AnswerDTO> answers) throws IOException {
        String loggedInUser = getLoggedInUser();
        return new ResponseEntity<>(this.diagnosticService.getDiagnostics(answers, loggedInUser), HttpStatus.OK);
    }

    @GetMapping(value="diagnostic/get/sym/{symptom}")
    @PreAuthorize("hasAuthority('diagnostic_answer_get')")
    public ResponseEntity<List<String>> back(@PathVariable String symptom) throws IOException {
        return new ResponseEntity<>(this.diagnosticService.getAllSymptoms(symptom), HttpStatus.OK);
    }

    @GetMapping(value="diagnostic/get/{id}")
    @PreAuthorize("hasAuthority('diagnostic_answer_get_id')")
    public ResponseEntity<List<QuestionAnswerDTO>> getAnswers(@PathVariable long id){
        return new ResponseEntity<>(this.resultService.getResultAnswers(id), HttpStatus.OK);  // result service
    }

    @GetMapping(value = "diagnostic/depression/mark")
    public ResponseEntity<?> getDepressionMark(){
        String loggedInUser = getLoggedInUser();
        List<DepressionMarkDTO> depressionMarksDTO = this.diagnosticService.getResultForDepressionMark(loggedInUser);
        return new ResponseEntity<>(depressionMarksDTO, HttpStatus.OK);
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }


    /*  dodavanje pravila, moglo bi ovo biti novi kontroler  */
    @PostMapping(value="new/rules")
    public ResponseEntity<?> addNewRules(@RequestBody RuleDTO ruleDTO) throws IOException {
        System.out.println(" nova pravila ---");
        System.out.println(ruleDTO.getRuleParams());
        System.out.println(ruleDTO.getMessage());
    //    try {
            this.diagnosticService.makeNewRules(ruleDTO);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "new/template")
    public ResponseEntity<?> addNewTemplateParam(@RequestBody List<TemplateParamDTO> templateParamDTOs) throws IOException {
        System.out.println(" novi template ---");
        this.diagnosticService.addTemplateRules(templateParamDTOs);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
