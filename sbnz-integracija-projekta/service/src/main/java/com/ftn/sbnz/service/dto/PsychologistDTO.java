package com.ftn.sbnz.service.dto;

import com.ftn.sbnz.model.Gender;
import com.ftn.sbnz.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PsychologistDTO {
    private long id;
    private String name;
    private String surname;
    private String email;
    private Gender gender;

    public PsychologistDTO(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.email = u.getEmail();
        this.gender = u.getGender();
    }
}
