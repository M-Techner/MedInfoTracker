package com.medinfotracker.medinfotracker.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile extends AbstractEntity {

//    @OneToOne
//    private User user;

//    @NotNull
//    @JoinColumn(name = "id")
//    private String userName;

    @NotNull
    private String userMedicalRecordName;

    @NotNull
    private String userAddress;

    @NotNull
    private String userPhoneNumber;

    @NotNull
    private String userEmail;

    @NotNull
    private String userDateOfBirth;

    @NotNull
    private String emergencyName;

    @NotNull
    private String emergencyPhoneNumber;

    @NotNull
    private String emergencyRelationship;

    @NotNull
    private String primaryCarePhysicianName;

    @NotNull
    private String primaryCarePhysicianAddress;

    @NotNull
    private String primaryCarePhysicianPhoneNumber;

//    @OneToMany
//    @ElementCollection
//    @JoinColumn(name = "userId")
    private String specialistName;
//    private final List<User> specialistName = new ArrayList<>();

//    @OneToMany
//    @ElementCollection
//    @JoinColumn(name = "userId")
    private String specialistPhoneNumber;
//    private final List<User> specialistPhoneNumber = new ArrayList<>();

//    @OneToMany
//    @ElementCollection
//    @JoinColumn(name = "userId")
    private String specialistType;
//    private final List<User> specialistType = new ArrayList<>();

//    @OneToMany
//    @ElementCollection
//    @JoinColumn(name = "userId")
    private String allergies;
//    private final List<User> allergies = new ArrayList<>();

//    @OneToMany
//    @ElementCollection
//    @JoinColumn(name = "userId")
    private String medicalConditions;
//    private final List<User> medicalConditions = new ArrayList<>();

    public Profile() {}

    public Profile(String aUserMedicalRecordName, String aUserAddress, String aUserPhoneNumber, String aUserEmail,
                   String aUserDateOfBirth, String anEmergencyName, String anEmergencyPhoneNumber, String anEmergencyRelationship,
                   String aPrimaryCarePhysicianName, String aPrimaryCarePhysicianAddress, String aPrimaryCarePhysicianPhoneNumber,
                   String aSpecialistName, String aSpecialistPhoneNumber, String aSpecialistType,
                   String someAllergies, String someMedicalConditions) {
        super();
//        this.userName = userName;
        this.userMedicalRecordName = aUserMedicalRecordName;
        this.userAddress = aUserAddress;
        this.userPhoneNumber = aUserPhoneNumber;
        this.userEmail = aUserEmail;
        this.userDateOfBirth = aUserDateOfBirth;
        this.emergencyName = anEmergencyName;
        this.emergencyPhoneNumber = anEmergencyPhoneNumber;
        this.emergencyRelationship = anEmergencyRelationship;
        this.primaryCarePhysicianName = aPrimaryCarePhysicianName;
        this.primaryCarePhysicianAddress  = aPrimaryCarePhysicianAddress;
        this.primaryCarePhysicianPhoneNumber = aPrimaryCarePhysicianPhoneNumber;
        this.specialistName = aSpecialistName;
        this.specialistPhoneNumber = aSpecialistPhoneNumber;
        this.specialistType = aSpecialistType;
        this.allergies =  someAllergies;
        this.medicalConditions = someMedicalConditions;
    }

//    public String getUserName() { return userName; }
//
//    public void setUserName(String userName) { this.userName = userName; }

    public String getUserMedicalRecordName() { return userMedicalRecordName; }

    public void setUserMedicalRecordName(String userMedicalRecordName) { this.userMedicalRecordName = userMedicalRecordName; }

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

}
