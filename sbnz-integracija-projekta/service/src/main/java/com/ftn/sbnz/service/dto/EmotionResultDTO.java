package com.ftn.sbnz.service.dto;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.EmotionResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmotionResultDTO {

    private DetectionType detectionType;
    private LocalDateTime time;

    public EmotionResultDTO(EmotionResult result) {
        if (result == null) return;
        this.detectionType = result.getDetected();
        this.time = result.getTime();
    }
}
