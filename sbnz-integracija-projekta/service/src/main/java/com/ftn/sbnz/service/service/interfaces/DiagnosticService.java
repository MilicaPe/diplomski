package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.service.dto.AnswerDTO;
import com.ftn.sbnz.service.dto.DepressionMarkDTO;
import com.ftn.sbnz.service.dto.ResultDTO;
import com.ftn.sbnz.service.dto.TemplateParamDTO;
import com.ftn.sbnz.service.dto.rules.RuleDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DiagnosticService {
    ArrayList<String> getAllSymptoms(String diagnostic) throws IOException;
    ResultDTO getDiagnostics(List<AnswerDTO> answers, String loggedInUser)  throws IOException;
    List<DepressionMarkDTO> getResultForDepressionMark(String userEmail);
    String makeNewRules(RuleDTO ruleDTO)  throws IOException;
    void addTemplateRules(List<TemplateParamDTO> templateParamDTOs) throws IOException;
}
