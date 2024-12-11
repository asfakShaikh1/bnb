package com.airbnb.service;


import com.airbnb.entity.AppUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiry.duration}")
    private long expiryTime;

   private Algorithm algorithm;

    @PostConstruct
    public void postConstruct() throws UnsupportedEncodingException {
            algorithm= Algorithm.HMAC256(algorithmKey);
            System.out.println(algorithmKey);
    }

    public String generateToken(AppUser user){

        if (user == null || user.username() == null) {
            throw new IllegalArgumentException("User or username cannot be null");
        }
        Instant now = Instant.now();
        Instant expiry = now.plus(expiryTime, ChronoUnit.MILLIS);
        Date expirationDate = Date.from(expiry);
        System.out.println("Expiration Date: " + expirationDate);
      return  JWT.create()
                .withClaim("username",user.username())
                .withExpiresAt(expirationDate)
                .withIssuer(issuer)
                .sign(algorithm);
    }
public String getUsername(String token){
    DecodedJWT decodedJwt = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
    return decodedJwt.getClaim("username").asString();
}


}
