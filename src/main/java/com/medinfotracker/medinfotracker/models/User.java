package com.medinfotracker.medinfotracker.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User extends AbstractEntity{

    @NotBlank
    @Size(min = 2, max = 60)
    private String userName;

    @NotNull
    @Size(min = 5, max = 60)
    private String pwHash;

    private String userAddress;

    private String userPhoneNumber;

    private String userEmail;

    private String userDateOfBirth;

    private String emergencyName;

    private String emergencyPhoneNumber;

    private String emergencyRelationship;

    private String primaryCarePhysicianName;

    private String primaryCarePhysicianAddress;

    private String primaryCarePhysicianPhoneNumber;

//    @OneToMany
    private String specialistName;

//    @OneToMany
    private String specialistPhoneNumber;

//    @OneToMany
    private String specialistType;

//    @OneToMany
    private String allergies;

//    @OneToMany
    private String medicalConditions;

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.pwHash = encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public User() {}

    public User(String userAddress, String userPhoneNumber, String userEmail,
                String userDateOfBirth, String emergencyName, String emergencyPhoneNumber, String emergencyRelationship,
                String primaryCarePhysicianName, String primaryCarePhysicianAddress, String primaryCarePhysicianPhoneNumber,
                String specialistName, String specialistPhoneNumber, String specialistType, String allergies, String medicalConditions) {
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userDateOfBirth = userDateOfBirth;
        this.emergencyName = emergencyName;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
        this.emergencyRelationship = emergencyRelationship;
        this.primaryCarePhysicianName = primaryCarePhysicianName;
        this.primaryCarePhysicianAddress  = primaryCarePhysicianAddress;
        this.primaryCarePhysicianPhoneNumber = primaryCarePhysicianPhoneNumber;
        this.specialistName = specialistName;
        this.specialistPhoneNumber = specialistPhoneNumber;
        this.specialistType = specialistType;
        this.allergies =  allergies;
        this.medicalConditions = medicalConditions;
    }

//    getters and setters

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserAddress() { return userAddress; }

    public void setUserAddress(String userAddress) { this.userAddress = userAddress; }

    public String getUserPhoneNumber() { return userPhoneNumber; }

    public void setUserPhoneNumber(String userPhoneNumber) { this.userPhoneNumber = userPhoneNumber; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserDateOfBirth() { return userDateOfBirth; }

    public void setUserDateOfBirth(String userDateOfBirth) { this.userDateOfBirth = userDateOfBirth; }

    public String getEmergencyName() { return emergencyName; }

    public void setEmergencyName(String emergencyName) { this.emergencyName = emergencyName; }

    public String getEmergencyPhoneNumber() { return emergencyPhoneNumber; }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) { this.emergencyPhoneNumber = emergencyPhoneNumber; }

    public String getEmergencyRelationship() { return emergencyRelationship; }

    public void setEmergencyRelationship(String emergencyRelationship) { this.emergencyRelationship = emergencyRelationship; }

    public String getPrimaryCarePhysicianName() { return primaryCarePhysicianName; }

    public void setPrimaryCarePhysicianName(String primaryCarePhysicianName) { this.primaryCarePhysicianName = primaryCarePhysicianName; }

    public String getPrimaryCarePhysicianAddress() { return primaryCarePhysicianAddress; }

    public void setPrimaryCarePhysicianAddress(String primaryCarePhysicianAddress) { this.primaryCarePhysicianAddress = primaryCarePhysicianAddress; }

    public String getPrimaryCarePhysicianPhoneNumber() { return primaryCarePhysicianPhoneNumber; }

    public void setPrimaryCarePhysicianPhoneNumber(String primaryCarePhysicianPhoneNumber) { this.primaryCarePhysicianPhoneNumber = primaryCarePhysicianPhoneNumber; }

    public String getSpecialistName() { return specialistName; }

    public void setSpecialistName(String specialistName) { this.specialistName = specialistName; }

    public String getSpecialistPhoneNumber() { return specialistPhoneNumber; }

    public void setSpecialistPhoneNumber(String specialistPhoneNumber) { this.specialistPhoneNumber = specialistPhoneNumber; }

    public String getSpecialistType() { return specialistType; }

    public void setSpecialistType(String specialistType) { this.specialistType = specialistType; }

    public String getAllergies() { return allergies; }

    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getMedicalConditions() { return medicalConditions; }

    public void setMedicalConditions(String medicalConditions) { this.medicalConditions = medicalConditions; }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
}
