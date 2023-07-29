package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.Answer;
import com.ftn.sbnz.model.Question;
import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.AnswerDTO;
import com.ftn.sbnz.service.repository.AnswerRepository;
import com.ftn.sbnz.service.repository.QuestionRepository;
import com.ftn.sbnz.service.service.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public Answer saveAnswer(AnswerDTO answerDTO, User user) {
        System.out.println("ans id:  " + answerDTO.getId() + "    SCORE : " + answerDTO.getScore());
        Question question = this.questionRepository.findById(answerDTO.getQuestionId()).orElseThrow(() -> new RuntimeException());
        Answer answer = new Answer();
        answer.setUser(user);
        answer.setTime(LocalDateTime.now());
        answer.setScore(answerDTO.getScore());
        answer.setQuestion(question);
        return this.answerRepository.save(answer);
    }

    public List<Answer> getAnswersByUserId(long userId)
    {
        return this.answerRepository.findByUserIdAndDate(userId, LocalDate.now());
    }
}
