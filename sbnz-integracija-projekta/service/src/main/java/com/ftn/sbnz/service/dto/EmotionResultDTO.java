package com.ftn.sbnz.service.dto;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Intensity;
import com.ftn.sbnz.model.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmotionResultDTO {

    private String detectionType;
    private LocalDateTime time;

    public EmotionResultDTO(Result result) {
        if (result == null) return;
        this.detectionType = result.getDetected();
        this.time = result.getTime();
    }
}
