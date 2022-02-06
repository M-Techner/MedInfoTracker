package com.medinfotracker.medinfotracker.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Symptoms extends AbstractEntity {

    @NotNull
    @Size(min=3, max=49)
    private String name;
    private String startDate;
    private String stopDate;
    private String description;

    public Symptoms() {
    }

    public Symptoms(String name, String startDate, String stopDate, String description) {
        this.name = name;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

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
}