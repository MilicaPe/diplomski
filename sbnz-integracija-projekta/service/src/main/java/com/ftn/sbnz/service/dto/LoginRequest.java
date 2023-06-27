package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank
//    @Pattern(regexp = "[a-zA-Z0-9]"//"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-8])(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&].{7,}$",
//            message = "Invalid password. Minimum 8 characters, upper and lower letters, number and symbol.")
    private String password;
}
