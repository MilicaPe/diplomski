package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.DetectionType;
import com.ftn.sbnz.model.DetectionTypeGroup;
import com.ftn.sbnz.service.dto.DetectionTypeDTO;
import com.ftn.sbnz.service.repository.DetectionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DetectionTypeService {
    @Autowired
    private DetectionTypeRepository detectionTypeRepository;

    public List<DetectionTypeDTO> getAllDetectionTypesMentalState(){
        List<DetectionType> types = this.detectionTypeRepository.getDetectionTypeByDetectionGroup(DetectionTypeGroup.MENTAL_STATE);
        return formDetectionTypeDTO(types);
    }

    private List<DetectionTypeDTO> formDetectionTypeDTO(List<DetectionType> types){
        List<DetectionTypeDTO> typeDTOS = new ArrayList<>();
        for(DetectionType dt: types){
            typeDTOS.add(new DetectionTypeDTO(dt.getType()));
        }
        return typeDTOS;
    }

    public DetectionType getDetectionType(String detection) {
        DetectionType detectionType = this.detectionTypeRepository.getDetectionTypeByType(detection);
        if(detectionType == null){
            DetectionType newDetectionType = new DetectionType();
            newDetectionType.setDetectionGroup(DetectionTypeGroup.MENTAL_STATE);
            newDetectionType.setType(detection);
            return this.detectionTypeRepository.save(newDetectionType);
        }
        return detectionType;
    }
}
