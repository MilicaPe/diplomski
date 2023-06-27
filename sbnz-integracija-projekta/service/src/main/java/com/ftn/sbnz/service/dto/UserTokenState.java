package com.ftn.sbnz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO koji enkapsulira generisani JWT i njegovo trajanje koji se vracaju klijentu
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenState {
    private String accessToken;
    private Long expiresIn;
}