package com.medinfotracker.medinfotracker.models;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User extends AbstractEntity{

    private String userAddress;

    private String userPhoneNumber;

    private String userEmail;

    private String userDateOfBirth;

    private String emergencyName;

    private String emergencyPhoneNumber;

    private String emergencyRelationship;

    private


//    getters and setters


}
