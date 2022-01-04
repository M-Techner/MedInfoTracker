package com.medinfotracker.medinfotracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User extends AbstractEntity{

    @NotBlank
    @NotNull
    @Size(min = 2, max = 60)
    private String userName;

    @NotNull
    @Size(min = 5, max = 60)
    private String pwHash;

    public User() {}

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.pwHash = encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

//    getters and setters

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
}
