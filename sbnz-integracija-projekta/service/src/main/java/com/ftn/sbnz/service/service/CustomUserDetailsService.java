package com.ftn.sbnz.service.service;


import com.ftn.sbnz.model.Privileges;
import com.ftn.sbnz.model.Role;
import com.ftn.sbnz.model.User;
import com.ftn.sbnz.service.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

// Ovaj servis je namerno izdvojen kao poseban u ovom primeru.
// U opstem slucaju UserServiceImpl klasa bi mogla da implementira UserDetailService interfejs.
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    // Funkcija koja na osnovu username-a iz baze vraca objekat User-a
    @Override
    public UserDetailsDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {

            Set<GrantedAuthority> authorities = new HashSet<>();

//        for (UserToRole userToRole : userAccount.getUserToRoles()) {
            Role userToRole = user.getRole();
            //authorities.add(new SimpleGrantedAuthority("ROLE_" + userToRole.getName()));
            for (Privileges userRoleToPrivilege : userToRole.getPrivileges()) {
                authorities.add(new SimpleGrantedAuthority(userRoleToPrivilege.getName()));
            }
//        }

//            user.setAuthorities(authorities);
            return new UserDetailsDTO(user, authorities);
        }
    }

}