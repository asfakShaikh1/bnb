package com.airbnb.config;

import com.airbnb.entity.AppUser;
import com.airbnb.repository.AppUserRepository;
import com.airbnb.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JWTFilter extends OncePerRequestFilter {


    private final JWTService jwtService;
    private final AppUserRepository appUserRepository;

    public JWTFilter(JWTService jwtService, AppUserRepository appUserRepository) {
        this.jwtService = jwtService;
        this.appUserRepository = appUserRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
       if(token!=null&& token.startsWith("Bearer ")){
         String tokenVal=  token.substring(8,token.length()-1);
         System.out.println(tokenVal);
         String username = jwtService.getUsername(tokenVal);
           Optional<AppUser> opUsername = appUserRepository.findByUsername(username);
           if(opUsername.isPresent()){
               AppUser appUser=opUsername.get();
               UsernamePasswordAuthenticationToken auth= new UsernamePasswordAuthenticationToken(appUser,null,null);
               auth.setDetails(new WebAuthenticationDetails(request));
               SecurityContextHolder.getContext().setAuthentication(auth);
           }

       }
   filterChain.doFilter(request,response);
    }
}
