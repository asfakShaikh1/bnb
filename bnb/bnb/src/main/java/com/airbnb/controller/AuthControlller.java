package com.airbnb.controller;

import com.airbnb.entity.AppUser;
import com.airbnb.exception.UserExists;
import com.airbnb.payload.JWTToken;
import com.airbnb.payload.LoginDto;
import com.airbnb.repository.AppUserRepository;
import com.airbnb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class AuthControlller {

    private final UserService userService;

    private final AppUserRepository appUserRepository;

   public AuthControlller(UserService userService,AppUserRepository appUserRepository){
       this.userService=userService;
       this.appUserRepository=appUserRepository;
   }




   @PostMapping("/signup")
    public ResponseEntity<AppUser>createUser(@RequestBody AppUser user){

        Optional<AppUser> email =appUserRepository.findByEmail(user.email());
        if(email.isPresent()){
            throw new UserExists("Email id exist");
        }

        AppUser savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

   @PostMapping("/login")
    public ResponseEntity<?>signIn(@RequestBody LoginDto loginDto){
       String token = userService.verifyLogin(loginDto);
       JWTToken jwtToken= new JWTToken();

       System.out.println(token);

       if(token!=null){
           jwtToken.setToken(token);
           jwtToken.setTokenType("JWT");
           System.out.println("asfak==========11");
           return new ResponseEntity<>(jwtToken,HttpStatus.OK);
       }else{
           return new ResponseEntity<>("SignIn failed",HttpStatus.BAD_REQUEST);
       }
    }


}
