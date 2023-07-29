package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.model.Answer;
import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {
    Answer saveAnswer(AnswerDTO answerDTO, User user);
    List<Answer> getAnswersByUserId(long userId);

}
