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
@AllArgsConstructor
@NoArgsConstructor
public class EmotionHistoryDTO {
    private long id;
    private LocalDateTime time;
    private DetectionType detectionType;
    private boolean emotion;

    public EmotionHistoryDTO(EmotionResult emotionResult) {
        this.id = emotionResult.getId();
        this.time = emotionResult.getTime();
        this.detectionType = emotionResult.getDetected();
        this.emotion = emotionResult.isEmotion();
    }
    /*

  id: number
  time: number[]
  detectionType: string
     */
}
