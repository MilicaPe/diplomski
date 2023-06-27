package com.ftn.sbnz.model.dto;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Intensity;
import com.ftn.sbnz.model.QuestionLayer;
import com.ftn.sbnz.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmotionDetection {
    private Intensity intensity;
    private User user;
    private QuestionLayer questionLayer;
    private DetectionType detectionType;
    private LocalDateTime time;
}
