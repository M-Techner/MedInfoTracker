package com.medinfotracker.medinfotracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User extends AbstractEntity {

    @OneToOne
    private Profile profile;

    @NotNull
    private String userName;

    @NotNull
    private String userEmail;

    @NotNull
    private String pwHash;

    public User() {}

    public User(String userName, String userEmail, String password) {
        super();
        this.userName = userName;
        this.userEmail = userEmail;
        this.pwHash = encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

//    getters and setters



    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



}
