package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.QuestionAnswerDTO;
import com.ftn.sbnz.service.dto.ResultDTO;

import java.util.List;

public interface ResultService {
    void saveResult(ResultDTO result, User user);
    List<QuestionAnswerDTO> getResultAnswers(long id);
}
