package com.ftn.sbnz.model.helper;

import com.ftn.sbnz.model.DetectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kie.api.definition.type.Position;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticState {
    @Position(0)
    public String symptom;
    @Position(1)
    public String diagnosticState;
}
