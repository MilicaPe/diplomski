package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.service.dto.DetectionTypeDTO;
import com.ftn.sbnz.service.service.interfaces.DetectionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DetectionTypeController {
    @Autowired
    private DetectionTypeService detectionTypeService;

    @GetMapping(value="detection/mental")
    public ResponseEntity<List<DetectionTypeDTO>> getDetectionTypes(){
        return new ResponseEntity<>(this.detectionTypeService.getAllDetectionTypesMentalState(), HttpStatus.OK);
    }

}
