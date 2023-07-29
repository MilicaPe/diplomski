package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.Gender;
import com.ftn.sbnz.model.Role;
import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.RegisterRequestDTO;
import com.ftn.sbnz.service.dto.UserDTO;
import com.ftn.sbnz.service.exception.AlreadyInUseException;
import com.ftn.sbnz.service.exception.NotFoundException;
import com.ftn.sbnz.service.repository.RoleRepository;
import com.ftn.sbnz.service.repository.UserRepository;
import com.ftn.sbnz.service.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public void register(RegisterRequestDTO registerRequestDTO) {
        User foundUserByEmail = userRepository.findByEmail(registerRequestDTO.getEmail());
        if (foundUserByEmail != null){
            throw new AlreadyInUseException("Email is already in use");
        }
        User user = new User();
        user.setEmail(registerRequestDTO.getEmail());
        user.setName(registerRequestDTO.getName());
        user.setSurname(registerRequestDTO.getSurname());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setLastPasswordResetDate(Timestamp.valueOf(LocalDateTime.now()));
        user.setYearOfBirth(Integer.parseInt(registerRequestDTO.getYearOfBirth()));
        user.setJob(registerRequestDTO.getJob());

        Role role = roleRepository.findById(Long.valueOf(registerRequestDTO.getType())).orElseThrow(() -> new NotFoundException("Role not found"));
        user.setRole(role);
        user.setEnabled(true);
        user.setGender(Gender.valueOf(Integer.parseInt(registerRequestDTO.getGender())));
        userRepository.save(user);
    }

    public List<UserDTO> getClientsForPsychologist(String psychologistEmail) {
        User psychologist = this.userRepository.findByEmail(psychologistEmail);
        List<User> users = psychologist.getClients();
        return this.formUserDtoList(users);
    }

    private List<UserDTO>formUserDtoList(List<User>users){
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User u : users){
            userDTOS.add(new UserDTO(u.getId(), u.getName(), u.getSurname(), u.getEmail(),
                    u.getGender().toString(), u.getYearOfBirth(), u.getJob()));
        }
        return userDTOS;
    }

    public List<String> getJobs() {
        return this.userRepository.findAllJobs();
    }
}
