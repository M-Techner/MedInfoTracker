package com.medinfotracker.medinfotracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.medinfotracker.medinfotracker.models.*;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.*;
import com.medinfotracker.medinfotracker.controllers.*;

import javax.persistence.OneToMany;


import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Symptoms extends AbstractEntity {



    private String startDate;
    private String stopDate;
    private String description;
//    @ManyToOne
//    private User user;
    private String userName;
    @NotNull
    private String symptomName;
    //    @Size(min=3, max=49)


//    private String userName;

    public Symptoms() {
    }

    public Symptoms(int id, String aSymptomName, String aStartDate, String aStopDate, String aDescription, String aUserName) {

//        super(id, name);
        super();

//        super(id, name);

        this.symptomName = aSymptomName;
        this.startDate = aStartDate;
        this.stopDate = aStopDate;
        this.description = aDescription;

        this.userName = aUserName;
//    }

//    @Override


    }


    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return this.stopDate;
    }

    public void setStopDate(final String stopDate) {
        this.stopDate = stopDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getSymptomName() {
        return this.symptomName;
    }

    public void setSymptomName(final String symptomName) {
        this.symptomName = symptomName;
    }

    //    public String getName() {
//        return this.name;
//    }
//
//    public void setName(final String name) {
//        this.name = name;
//    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptoms that = (Symptoms) o;
        return Objects.equals(symptomName, that.symptomName) && Objects.equals(startDate, that.startDate) && Objects.equals(stopDate, that.stopDate) && Objects.equals(description, that.description);

    }
}

