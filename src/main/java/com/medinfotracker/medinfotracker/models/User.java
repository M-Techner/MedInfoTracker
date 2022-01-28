package com.medinfotracker.medinfotracker.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.domain.*;

import javax.persistence.Entity;
import javax.validation.*;
import javax.validation.constraints.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.*;
import java.util.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.*;
import javax.validation.*;
@Entity
public class User extends AbstractEntity{

    private String userAddress;

    private String userPhoneNumber;

    private String userEmail;

    private String userDateOfBirth;

    private String emergencyName;

    private String emergencyPhoneNumber;

    private String emergencyRelationship;

//    private

    public User() {
    }

    public User(String userAddress, String userPhoneNumber, String userEmail, String userDateOfBirth, String emergencyName, String emergencyPhoneNumber, String emergencyRelationship) {
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userDateOfBirth = userDateOfBirth;
        this.emergencyName = emergencyName;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
        this.emergencyRelationship = emergencyRelationship;
    }
//    getters and setters


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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(String userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
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
}
