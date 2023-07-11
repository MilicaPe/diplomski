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

    private String detected;

    private LocalDateTime time;

    public Result(User user, String detected, LocalDateTime time) {
        this.user = user;
        this.detected = detected;
        this.time = time;
    }

    public boolean isEmotion() {
        if (detected.equals("SAD") || detected.equals("BAD") || detected.equals("DISGUSTED") ||
                detected.equals("FEARFUL") || detected.equals("HAPPY") || detected.equals("SURPRISED") ||
                detected.equals("ANGRY")) return true;
        return false;
    }
}
