package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.DiagnosticTemplate;
import com.ftn.sbnz.service.repository.DiagnosticTemplateRepository;
import com.ftn.sbnz.service.service.interfaces.DiagnosticTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DiagnosticTemplateServiceImpl implements DiagnosticTemplateService {
    @Autowired
    private DiagnosticTemplateRepository diagnosticTemplateRepository;

    public List<DiagnosticTemplate> getAll(){
        return this.diagnosticTemplateRepository.findAll();
    }

    public DiagnosticTemplate save(DiagnosticTemplate diagnosticTemplate) {
        return this.diagnosticTemplateRepository.save(diagnosticTemplate);
    }
}
