package com.airbnb.service;

import com.airbnb.entity.AppUser;
import com.airbnb.payload.LoginDto;
import com.airbnb.repository.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public  class UserServiceImpl implements UserService {





     private final AppUserRepository appUserRepository;
     private final JWTService jwtService;
    public UserServiceImpl(AppUserRepository appUserRepository,JWTService jwtService) {
        this.appUserRepository = appUserRepository;
        this.jwtService=jwtService;
    }

    public AppUser createUser(AppUser user){
        String encodedPassword = BCrypt.hashpw(user.password(),BCrypt.gensalt(4));
        user.setPassword(encodedPassword);
        return appUserRepository.save(user);
    }

    @Override
    public String verifyLogin(LoginDto loginDto) {
        Optional<AppUser> opUser = appUserRepository.findByEmail( loginDto.email());
        System.out.println(opUser+" ....this is prasent....");
        if(opUser.isPresent()){
            AppUser appUser = opUser.get();
            System.out.println(appUser+" ....this is prasent....");
           if(BCrypt.checkpw(loginDto.pwd(),appUser.password())){
               return jwtService.generateToken(appUser);
            }
        }
    return null;
    }

}
