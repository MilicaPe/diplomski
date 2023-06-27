package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.service.service.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "psychologist/", produces = MediaType.APPLICATION_JSON_VALUE)
public class PsychologistController {

    @Autowired
    private PsychologistService psychologistService;

    @GetMapping(value = "search")
    @PreAuthorize("hasAuthority('search_for_psychologist')")
    public ResponseEntity<?> searchForPsychologist(@RequestParam("search") String searchParam){
        return new ResponseEntity<>(psychologistService.findPsychologist(searchParam), HttpStatus.OK);
    }

    @GetMapping(value = "get")
    @PreAuthorize("hasAuthority('get_psychologist')")
    public ResponseEntity<?> getPsychologist(){
        String loggedInUser = getLoggedInUser();
        return new ResponseEntity<>(psychologistService.getPsychologists( loggedInUser), HttpStatus.OK);
    }
    @GetMapping(value = "add/{id}")
    @PreAuthorize("hasAuthority('add_psychologist')")
    public ResponseEntity<?> addPsychologist(@PathVariable long id){
        String loggedInUser = getLoggedInUser();
        return new ResponseEntity<>(psychologistService.addPsychologist(id, loggedInUser), HttpStatus.OK);
    }

    @GetMapping(value = "remove/{id}")
    @PreAuthorize("hasAuthority('remove_psychologist')")
    public ResponseEntity<?> removePsychologist(@PathVariable long id){
        String loggedInUser = getLoggedInUser();
        psychologistService.removePsychologist(id, loggedInUser);
        return new ResponseEntity<>(psychologistService.getPsychologists(loggedInUser), HttpStatus.OK);
    }

    private String getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
