package com.ftn.sbnz.service.dto;

import com.ftn.sbnz.model.helper.Diagnostic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {
    private List <Diagnostic> diagnostics;
}
