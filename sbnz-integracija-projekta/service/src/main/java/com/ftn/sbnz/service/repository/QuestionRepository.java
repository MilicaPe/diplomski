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
    @Query("select q from Question q where q.detectionType = ?1")
    List<Question> findByDetectionType(DetectionType detectionType);


    List<Question> getQuestionsByDetectionTypeAndQuestionLayer(DetectionType detectionType, QuestionLayer questionLayer);

}
