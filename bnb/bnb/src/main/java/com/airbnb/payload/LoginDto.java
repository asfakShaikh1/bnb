package com.airbnb.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDto {
    public String pwd() {
        return pwd;
    }

    public LoginDto setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    private String pwd;

    public String email() {
        return email;
    }

    public LoginDto setEmail(String email) {
        this.email = email;
        return this;
    }

    private String email;
}
