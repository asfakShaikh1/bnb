package com.airbnb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests((authz) -> authz
                .anyRequest().permitAll()
               // .requestMatchers("/public/**").permitAll()             // Public access
                //.requestMatchers("/admin/**").hasRole("ADMIN")         // Restrict access to ADMIN role
                //.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // USER or ADMIN role access
                //.anyRequest().authenticated()                          // All other requests require authentication
        );

       return http.build();
    }
}
