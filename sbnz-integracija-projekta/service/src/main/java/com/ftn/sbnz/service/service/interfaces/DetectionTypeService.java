package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.service.dto.DetectionTypeDTO;

import java.util.List;

public interface DetectionTypeService {
    List<DetectionTypeDTO> getAllDetectionTypesMentalState();
    DetectionType getDetectionType(String detection);
}
