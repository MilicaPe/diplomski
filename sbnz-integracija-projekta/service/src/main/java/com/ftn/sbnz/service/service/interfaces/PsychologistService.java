package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.service.dto.PsychologistDTO;

import java.util.Set;

public interface PsychologistService {
    Set<PsychologistDTO> findPsychologist(String searchParam);
    boolean addPsychologist(long id, String loggedInUser);
    Set getPsychologists(String loggedInUser);
    boolean removePsychologist(long id, String loggedInUser);
}
