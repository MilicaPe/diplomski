package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Question;
import com.ftn.sbnz.model.QuestionLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("select q from Question q where q.detectionType.type = ?1")
    List<Question> findByDetectionType(String detectionType);

    @Query("select q from Question q where q.detectionType.type = ?1 and q.questionLayer = ?2")
    List<Question> getQuestionsByDetectionTypeAndQuestionLayer(String detectionType, QuestionLayer questionLayer);

    @Query("select q from Question q where q.depressionMark = true")
    List<Question>getQuestionsByPositiveDepressionMark();
}
