package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.service.dto.UserDTO;
import com.ftn.sbnz.service.dto.UserDetailsDTO;
import com.ftn.sbnz.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "clients")
    @PreAuthorize("hasAuthority('user_clients')")
    public ResponseEntity<List<UserDTO>> getClients(){
        String loggedInUser = getLoggedInUser();
        return new ResponseEntity<>(this.userService.getClientsForPsychologist(loggedInUser), HttpStatus.OK);
    }

    @GetMapping(value = "job")
    @PreAuthorize("hasAuthority('user_job')")
    public ResponseEntity<List<String>> getJobs(){
        return new ResponseEntity<>(this.userService.getJobs(), HttpStatus.OK);
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
