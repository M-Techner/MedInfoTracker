package com.medinfotracker.medinfotracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User extends AbstractEntity {

    @OneToOne
    private Profile profile;

    @OneToMany
    private List<Medication> medications = new ArrayList<>();

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String userName;


    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String userEmail;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String userName, String userEmail, String password) {
        super();
//        this.name = userName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.pwHash = encoder.encode(password);
    }

    public User(String userName, String userEmail, String password, List<Medication> medications) {
        super();
//        this.name = userName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.pwHash = encoder.encode(password);
        this.medications = medications;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void deleteProfile(Profile profile) {
        this.profile = null;
    }
}