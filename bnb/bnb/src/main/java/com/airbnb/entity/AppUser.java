package com.airbnb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class AppUser {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String username() {
        return username;
    }

    public AppUser setUsername(String username) {
        this.username = username;
        return this;
    }

    private String name;

    public String email() {
        return email;
    }

    public AppUser setEmail(String email) {
        this.email = email;
        return this;
    }

    private String email;

    public String password() {
        return password;
    }

    public AppUser setPassword(String password) {
        this.password = password;
        return this;
    }

    private String password;
   private String username;


}