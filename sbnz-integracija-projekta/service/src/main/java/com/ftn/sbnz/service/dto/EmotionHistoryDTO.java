package com.ftn.sbnz.service.dto;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Result;
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
    private String detectionType;
    private boolean emotion;
    private String intensity;

    public EmotionHistoryDTO(Result result) {
        this.id = result.getId();
        this.time = result.getTime();
        this.detectionType = result.getDetected();
        this.emotion = result.isEmotion();
        if(result.getIntensity() != null)  {this.intensity = result.getIntensity().toString();}
    }
    /*

  id: number
  time: number[]
  detectionType: string
     */
}
