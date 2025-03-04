package com.wings.usermanagement.Class;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// spring boot wala thiyena inbuild class me MyUserDetailsService
//@Service
public class MyUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder ;

    public MyUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserDetails user = User.builder()
                .username("amila")
                .password(passwordEncoder.encode("amila"))
                .build() ;
        return user;
    }

}
