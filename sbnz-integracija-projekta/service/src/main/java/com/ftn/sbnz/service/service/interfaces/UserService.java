package com.ftn.sbnz.service.service.interfaces;

import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.RegisterRequestDTO;
import com.ftn.sbnz.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findByEmail(String username);
    void register(RegisterRequestDTO registerRequestDTO);
    List<UserDTO> getClientsForPsychologist(String psychologistEmail);
    List<String> getJobs();
}
