package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.DiagnosticTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticTemplateRepository extends JpaRepository<DiagnosticTemplate, Long> {

    //@Query("select a from DiagnosticTemplate")
    List<DiagnosticTemplate> findAll();
}
