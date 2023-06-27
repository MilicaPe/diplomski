package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.EmotionResult;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EmotionResultRepository extends JpaRepository<EmotionResult, Long> {
    @Query("select e from EmotionResult e where e.user.email = ?1")
    List<EmotionResult> findByEmail(String email, PageRequest pageRequest);

    @Query("select count(e) from EmotionResult e where e.user.email = ?1")
    long countByUserEmail(String email);

    List<EmotionResult> findAllByUserId(long userId, PageRequest pageRequest);

    @Query("select count(e) from EmotionResult e where e.user.id = ?1")
    long countByUserId(long id);

    @Query("select e from EmotionResult e where e.detected=?1 and e.time>=?2 and e.time<=?3 order by e.time")
    List<EmotionResult> findAllByDetectedAndTime(DetectionType d, LocalDateTime start, LocalDateTime end);


}
