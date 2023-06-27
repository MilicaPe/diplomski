package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    private String email;
    private String name;
    private String surname;
    private String password;
    private String gender;
    private String yearOfBirth;
    private String job;
    private String type;

}
