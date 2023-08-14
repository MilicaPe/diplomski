package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.Result;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query("select e from Result e where e.user.email = ?1")
    List<Result> findByEmail(String email, PageRequest pageRequest);

    @Query("select count(e) from Result e where e.user.email = ?1")
    long countByUserEmail(String email);

    List<Result> findAllByUserId(long userId, PageRequest pageRequest);

    @Query("select count(e) from Result e where e.user.id = ?1")
    long countByUserId(long id);

    @Query("select e from Result e where e.detected=?1 and e.time>=?2 and e.time<=?3 order by e.time asc ")
    List<Result> findAllByDetectedAndTime(String d, LocalDateTime start, LocalDateTime end);


}
