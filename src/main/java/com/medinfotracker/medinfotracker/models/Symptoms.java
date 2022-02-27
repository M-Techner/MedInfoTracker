package com.medinfotracker.medinfotracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.medinfotracker.medinfotracker.models.*;
import com.medinfotracker.medinfotracker.models.User;
import com.medinfotracker.medinfotracker.models.data.*;
import com.medinfotracker.medinfotracker.controllers.*;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
@Entity
public class Symptoms extends AbstractEntity {




    private String startDate;
    private String stopDate;
    private String description;
//    @OneToMany
//    private User user;

    private String userName;
    @NotNull
    private String name;
    public Symptoms() {
    }



    public Symptoms(int id, String name, String name1, String startDate, String stopDate, String description, String userName) {
//        super(id, name);
        super();
        this.name = name1;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.description = description;
        this.userName = userName;
    }

    //    @Override
    public String getName() {
        return name;
    }

    //    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}