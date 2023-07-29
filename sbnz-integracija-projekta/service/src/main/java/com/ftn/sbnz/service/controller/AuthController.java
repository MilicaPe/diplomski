package com.ftn.sbnz.service.controller;

import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.LoginRequest;
import com.ftn.sbnz.service.dto.RegisterRequestDTO;
import com.ftn.sbnz.service.dto.UserTokenState;
import com.ftn.sbnz.service.repository.UserRepository;
import com.ftn.sbnz.service.service.UserServiceImpl;
import com.ftn.sbnz.service.service.helper.FileService;
import com.ftn.sbnz.service.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private FileService fileService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = null;
        try {
            user = userRepository.findByEmail(request.getEmail().trim());
            // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
            // AuthenticationException
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(), request.getPassword()));


            // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
            // kontekst
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Kreiraj token za tog korisnika
            String fingerprint = tokenUtils.generateFingerprint();
            String jwt = tokenUtils.generateToken(user.getEmail(), user.getRole().getName(), fingerprint);
            long expiresIn = tokenUtils.getExpiredIn();


            // Kreiraj cookie
            // String cookie = "__Secure-Fgp=" + fingerprint + "; SameSite=Strict; HttpOnly; Path=/; Secure";
            // kasnije mozete probati da postavite i ostale atribute, ali tek nakon sto podesite https
            String cookie = "Fingerprint=" + fingerprint + "; HttpOnly; Path=/";
//Domain=http://localhost:4200/;

            HttpHeaders headers = new HttpHeaders();
            headers.add("Set-Cookie", cookie);
//            System.out.println("ADDED Fingerprint");
//            System.out.println(cookie);

            return ResponseEntity.ok().headers(headers).body(new UserTokenState(jwt, expiresIn));

        } catch (BadCredentialsException e) {

            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<Boolean> test(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) throws IOException {
        try {
            this.userService.register(registerRequestDTO);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }
    @GetMapping(value = "/logout")
    @PreAuthorize("hasAuthority('logout')")
    public ResponseEntity<?> logoutUser(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        try {
            if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
                String token = bearerToken.substring(7);
                URL res = getClass().getClassLoader().getResource("static/stores/tokenBlacklist.txt");
                if (res == null) {
                    fileService.createFile("", "tokenBlacklist.txt");
                }
                res = getClass().getClassLoader().getResource("static/stores/tokenBlacklist.txt");
                File file = Paths.get(res.toURI()).toFile();

                FileWriter fw = null;
                try {
                    fw = new FileWriter(file, true);
                    fw.write(token + "\n");
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
