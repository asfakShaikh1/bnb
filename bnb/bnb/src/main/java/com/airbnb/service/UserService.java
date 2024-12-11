package com.airbnb.service;

import com.airbnb.entity.AppUser;
import com.airbnb.payload.LoginDto;

public interface UserService {
    public AppUser createUser(AppUser user);
    public String verifyLogin(LoginDto loginDto);
}
