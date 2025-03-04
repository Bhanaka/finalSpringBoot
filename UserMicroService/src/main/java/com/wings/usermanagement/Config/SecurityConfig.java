package com.wings.usermanagement.Config;

import com.wings.usermanagement.Class.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    private final MyUserDetailsService myUserDetailsService ;
//
//    public SecurityConfig(MyUserDetailsService myUserDetailsService) {
//        this.myUserDetailsService = myUserDetailsService;
//    }

    @Bean
    // http request enakota default security filterchain eka bean object overwrite wenawa .
    // login request nomethiwa ithuruwa security check wennawa
    //httpBasic pavichchi krna auth type kiynna one

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return  httpSecurity
                    .csrf(c->c.disable())
                    .sessionManagement(s->s.
                            sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(r->r.
                        requestMatchers("/login")
                        .permitAll().anyRequest().authenticated()
                    )
                .httpBasic(Customizer.withDefaults())
                .build() ;
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder() );
        return provider ;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new MyUserDetailsService(passwordEncoder());
    }
}
