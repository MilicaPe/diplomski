package com.ftn.sbnz.model.helper;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Intensity;
import com.ftn.sbnz.model.QuestionLayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostic {
    private long userId;
    private Intensity intensity;
    private String detectionType;
    private QuestionLayer questionLayer;

    private QuestionLayer nextLayer;
    private String nextDetection;
    private String text;
    private boolean finalResult;

}
