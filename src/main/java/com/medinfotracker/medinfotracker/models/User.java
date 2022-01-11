package com.medinfotracker.medinfotracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User extends AbstractEntity {

    @OneToOne
//    @JoinColumn(name = "user_id")
//    private final List<Profile> profile = new ArrayList<>();
    private Profile userProfile;

//    @NotNull
//    @JoinColumn(name = "id")
//    private int id;

    @NotNull
    private String userName;

    @NotNull
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


//    public List<Profile> getProfile() { return profile; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


}
