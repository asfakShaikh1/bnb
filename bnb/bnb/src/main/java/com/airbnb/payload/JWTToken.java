package com.airbnb.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JWTToken {

    public String tokenType() {
        return tokenType;
    }

    public JWTToken setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    private String tokenType;

    public String token() {
        return token;
    }

    public JWTToken setToken(String token) {
        this.token = token;
        return this;
    }

    private String token;
}
