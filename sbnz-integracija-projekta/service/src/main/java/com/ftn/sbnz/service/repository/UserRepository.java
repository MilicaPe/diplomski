package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.Gender;
import com.ftn.sbnz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


    @Query("select u from users u where u.role.id = ?1")
    List<User> findByRoleId(Long id);

    List<User> findAllByRoleId(long roleId);

    @Query("select distinct e.job from users e")
    List<String> findAllJobs();

    @Query("select e from users e where e.gender=?1 and e.job=?2 and e.yearOfBirth>=?3 and e.yearOfBirth<=?4")
    List<User> findUsersByJobAAndGenderAndYearOfBirth(Gender g, String job, int start, int end);




}
