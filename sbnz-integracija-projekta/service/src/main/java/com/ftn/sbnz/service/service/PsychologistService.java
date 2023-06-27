package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.PsychologistDTO;
import com.ftn.sbnz.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PsychologistService {

    @Autowired
    private UserRepository userRepository;

    public Set<PsychologistDTO> findPsychologist(String searchParam) {
        List<User> psychologists = userRepository.findByRoleId(1L);
        String[] params = searchParam.split(" ");
        Set<User> result = new HashSet<>();
        for (String p: params){
            for (User u: psychologists){
                if (u.containsInNameOrEmail(p))
                    result.add(u);
            }
        }
        return convertToPsychologistDTO(result);
    }

    private Set<PsychologistDTO> convertToPsychologistDTO(Set<User> users) {
        Set<PsychologistDTO> result = new HashSet<>();
        for (User u: users){
            result.add(new PsychologistDTO(u));
        }
        return result;
    }

    public boolean addPsychologist(long id, String loggedInUser) {
        User user = this.userRepository.findByEmail(loggedInUser);
        User psychologist = this.userRepository.findById(id).orElse(null);
        user.addPsychologist(psychologist);
        this.userRepository.save(user);
        return true;
    }

    public Set getPsychologists(String loggedInUser) {
        User user = this.userRepository.findByEmail(loggedInUser);
        Set set = new HashSet<>(user.getPsychologists());
        return convertToPsychologistDTO(set);
    }

    public boolean removePsychologist(long id, String loggedInUser) {
        User user = this.userRepository.findByEmail(loggedInUser);
        User psychologist = this.userRepository.findById(id).orElse(null);
        user.removePsychologist(psychologist);
        this.userRepository.save(user);
        return true;
    }
}
