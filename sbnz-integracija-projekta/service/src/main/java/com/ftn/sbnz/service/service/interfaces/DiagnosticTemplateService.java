package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.model.DiagnosticTemplate;

import java.util.List;

public interface DiagnosticTemplateService {
    List<DiagnosticTemplate> getAll();
    DiagnosticTemplate save(DiagnosticTemplate diagnosticTemplate);
}
