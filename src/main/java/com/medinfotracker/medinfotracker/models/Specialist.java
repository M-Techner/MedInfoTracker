//package com.medinfotracker.medinfotracker.models;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Specialist extends AbstractEntity {
//
//    @ManyToOne
//    private Profile profile;
//
//    public String specialistName;
//
//    public String specialistPhoneNumber;
//
//    public  String specialistType;
//
//    public Specialist () {}
//
//    public Specialist(Profile profile, String specialistName, String specialistPhoneNumber, String specialistType) {
//        super();
//        this.profile = profile;
//        this.specialistName = specialistName;
//        this.specialistPhoneNumber = specialistPhoneNumber;
//        this.specialistType = specialistType;
//    }
//
//    public Profile getProfile() { return profile; }
//
//    public void setProfile(Profile profile) { this.profile = profile; }
//
//    public String getSpecialistName() { return specialistName; }
//
//    public void setSpecialistName(String specialistName) { this.specialistName = specialistName; }
//
//    public String getSpecialistPhoneNumber() { return specialistPhoneNumber; }
//
//    public void setSpecialistPhoneNumber(String specialistPhoneNumber) { this.specialistPhoneNumber = specialistPhoneNumber; }
//
//    public String getSpecialistType() { return specialistType; }
//
//    public void setSpecialistType(String specialistType) { this.specialistType = specialistType; }
//}
