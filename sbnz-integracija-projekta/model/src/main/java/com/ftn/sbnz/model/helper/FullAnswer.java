package com.ftn.sbnz.model.helper;

import com.ftn.sbnz.model.Question;
import com.ftn.sbnz.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullAnswer {
    private long id;
    private User user;
    private Question question;
    private int score;
    private boolean positive;

    @Override
    public String toString() {
        return "FullAnswer{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                ", score=" + score +
                '}';
    }
}


