package com.ftn.sbnz.service.repository;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.DetectionTypeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetectionTypeRepository extends JpaRepository<DetectionType, Long> {

    DetectionType getDetectionTypeByType(String type);
    DetectionType getDetectionTypeById(Long id);
    List<DetectionType> getDetectionTypeByDetectionGroup(DetectionTypeGroup group);
}
