package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.DepressionMarkResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepressionMarkResultRepository extends JpaRepository<DepressionMarkResult, Long> {

}
