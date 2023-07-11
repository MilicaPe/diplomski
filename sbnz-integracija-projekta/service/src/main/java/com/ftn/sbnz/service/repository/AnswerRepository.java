package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.Answer;
import com.ftn.sbnz.model.QuestionLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Query("select a from Answer a where a.user.id = ?1 and a.time = ?2")
    List<Answer> findByUserIdAndTime(Long id, LocalDateTime time);

    @Query("select a from Answer a where a.user.id = ?1 and a.time >= ?2 and a.time <= ?3 and a.question.detectionType.type=?4 and a.question.questionLayer=?5")
    List<Answer> findByUserIdAndTimeForDiagnostic(Long id, LocalDateTime start, LocalDateTime end, String d, QuestionLayer l);

    @Query("select a from Answer a where a.user.id = ?1 and DATE(a.time) = ?2")
    List<Answer> findByUserIdAndDate(Long id, LocalDate date);
}
