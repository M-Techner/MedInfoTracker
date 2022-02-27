package com.medinfotracker.medinfotracker.Models;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

    //private List<Skill> skills = new ArrayList<>();

    @OneToMany
    private List<Medication> medications = new ArrayList<>();


private String userName;
public User(String userName, String password) {
    this.userName = userName;
    //this.userEmail = userEmail;
    //this.pwHash = encoder.encode(password);
    }


    //public List<Medication> getMedications() {return medications;}

    public List<Medication> getmedications() { return medications; }

    public void addmedications(List<Medication> medications) { this.medications = medications; }


    @Override





    public boolean isMatchingPassword(String password) {
        return false;
    }





}

