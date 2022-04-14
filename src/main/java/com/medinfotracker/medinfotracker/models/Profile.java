package com.medinfotracker.medinfotracker.models;


import javax.persistence.*;

@Entity
public class Profile extends AbstractEntity {

//    @OneToOne
//    private User user;

    private String userPreferredName;

//    @NotNull
    private String userMedicalRecordName;

//    @NotNull
    private String userAddress;

//    @NotNull
    private String userPhoneNumber;

//    @NotNull
    private String userDateOfBirth;

    private String userPreferredPronouns;

//    @NotNull
    private String emergencyName;

//    @NotNull
    private String emergencyPhoneNumber;

//    @NotNull
    private String emergencyRelationship;

//    @NotNull
    private String primaryCarePhysicianName;

//    @NotNull
    private String primaryCarePhysicianAddress;

//    @NotNull
    private String primaryCarePhysicianPhoneNumber;


    private String specialistName;

    private String specialistPhoneNumber;

    private String specialistType;

    private String allergies;

    private String medicalConditions;


    public Profile() {}

    public Profile(String userPreferredName, String userMedicalRecordName, String userAddress, String userPhoneNumber,
                   String userDateOfBirth, String userPreferredPronouns, String emergencyName, String emergencyPhoneNumber, String emergencyRelationship,
                   String primaryCarePhysicianName, String primaryCarePhysicianAddress, String primaryCarePhysicianPhoneNumber,
                   String specialistName, String specialistPhoneNumber, String specialistType,
                   String allergies, String medicalConditions) {
        super();
        this.userPreferredName = userPreferredName;
        this.userPreferredPronouns = userPreferredPronouns;
        this.userMedicalRecordName = userMedicalRecordName;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
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

    public String getUserPreferredName() {
        return userPreferredName;
    }

    public void setUserPreferredName(String userPreferredName) {
        this.userPreferredName = userPreferredName;
    }

    public String getUserMedicalRecordName() {
        return userMedicalRecordName;
    }

    public void setUserMedicalRecordName(String userMedicalRecordName) {
        this.userMedicalRecordName = userMedicalRecordName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(String userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserPreferredPronouns() {
        return userPreferredPronouns;
    }

    public void setUserPreferredPronouns(String userPreferredPronouns) {
        this.userPreferredPronouns = userPreferredPronouns;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public String getEmergencyRelationship() {
        return emergencyRelationship;
    }

    public void setEmergencyRelationship(String emergencyRelationship) {
        this.emergencyRelationship = emergencyRelationship;
    }

    public String getPrimaryCarePhysicianName() {
        return primaryCarePhysicianName;
    }

    public void setPrimaryCarePhysicianName(String primaryCarePhysicianName) {
        this.primaryCarePhysicianName = primaryCarePhysicianName;
    }

    public String getPrimaryCarePhysicianAddress() {
        return primaryCarePhysicianAddress;
    }

    public void setPrimaryCarePhysicianAddress(String primaryCarePhysicianAddress) {
        this.primaryCarePhysicianAddress = primaryCarePhysicianAddress;
    }

    public String getPrimaryCarePhysicianPhoneNumber() {
        return primaryCarePhysicianPhoneNumber;
    }

    public void setPrimaryCarePhysicianPhoneNumber(String primaryCarePhysicianPhoneNumber) {
        this.primaryCarePhysicianPhoneNumber = primaryCarePhysicianPhoneNumber;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }

    public String getSpecialistPhoneNumber() {
        return specialistPhoneNumber;
    }

    public void setSpecialistPhoneNumber(String specialistPhoneNumber) {
        this.specialistPhoneNumber = specialistPhoneNumber;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }}

//    public String update(String userPreferredName, String userMedicalRecordName, String userAddress, String userPhoneNumber,
//                       String userDateOfBirth, String userPreferredPronouns, String emergencyName, String emergencyPhoneNumber, String emergencyRelationship,
//                       String primaryCarePhysicianName, String primaryCarePhysicianAddress, String primaryCarePhysicianPhoneNumber,
//                       String specialistName, String specialistPhoneNumber, String specialistType,
//                       String allergies, String medicalConditions) {
//        this.userPreferredName = userPreferredName;
//        this.userPreferredPronouns = userPreferredPronouns;
//        this.userMedicalRecordName = userMedicalRecordName;
//        this.userAddress = userAddress;
//        this.userPhoneNumber = userPhoneNumber;
//        this.userDateOfBirth = userDateOfBirth;
//        this.emergencyName = emergencyName;
//        this.emergencyPhoneNumber = emergencyPhoneNumber;
//        this.emergencyRelationship = emergencyRelationship;
//        this.primaryCarePhysicianName = primaryCarePhysicianName;
//        this.primaryCarePhysicianAddress  = primaryCarePhysicianAddress;
//        this.primaryCarePhysicianPhoneNumber = primaryCarePhysicianPhoneNumber;
//        this.specialistName = specialistName;
//        this.specialistPhoneNumber = specialistPhoneNumber;
//        this.specialistType = specialistType;
//        this.allergies =  allergies;
//        this.medicalConditions = medicalConditions;
//
//
//}
//return Profile updatedProfile;
//}
