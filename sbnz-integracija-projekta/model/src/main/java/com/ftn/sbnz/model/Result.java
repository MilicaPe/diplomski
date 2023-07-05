package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;

    private DetectionType detected;

    private LocalDateTime time;

    public Result(User user, DetectionType detected, LocalDateTime time) {
        this.user = user;
        this.detected = detected;
        this.time = time;
    }

    public boolean isEmotion() {
        if (detected == DetectionType.SAD || detected == DetectionType.BAD || detected == DetectionType.DISGUSTED ||
                detected == DetectionType.FEARFUL || detected == DetectionType.HAPPY || detected == DetectionType.SURPRISED ||
                detected == DetectionType.ANGRY) return true;
        return false;
    }
}
