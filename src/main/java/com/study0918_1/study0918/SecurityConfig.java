package com.study0918_1.study0918;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
            .cors(c -> c.disable())
            .csrf(c -> c.disable())
            .formLogin( config ->
                config.loginProcessingUrl("/login"))
            .authorizeHttpRequests(auth ->auth.anyRequest().permitAll())
            ;

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }


}
