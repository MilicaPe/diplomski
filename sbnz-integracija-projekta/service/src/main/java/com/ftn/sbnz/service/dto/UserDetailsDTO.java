package com.ftn.sbnz.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ftn.sbnz.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetailsDTO implements UserDetails {

    private Set<GrantedAuthority> authorities;
    private User user;

    public UserDetailsDTO(User user) {
        this.user = user;
    }

    public UserDetailsDTO(User user, Set<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

//    @JsonIgnore
//    @Override
//    public Set<GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//    public Set<GrantedAuthority> getAuthoritySet() {
//        return authorities;
//    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }


    public String getUsername() {
        return user.getEmail();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isEnabled();
    }


    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    public Date getLastPasswordResetDate() {
        return user.getLastPasswordResetDate();
    }
}
