package com.medinfotracker.medinfotracker.models;

import javax.persistence.Entity;

@Entity
public class Conditions extends AbstractEntity {
    private int id;
    private String name;
    private String specialist;
    private String description;
    private String dxDate;
    private String organs;

   



    public Conditions() {
    }

    public Conditions(int id, String name, String specialist, String description, String dxDate, String organs) {
        this.id = id;
        this.name = name;
        this.specialist = specialist;
        this.description = description;
        this.dxDate = dxDate;
        this.organs = organs;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDxDate() {
        return this.dxDate;
    }

    public void setDxDate(String dxDate) {
        this.dxDate = dxDate;
    }

    public String getSpecialist() {
        return this.specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getOrgans() {
        return this.organs;
    }

    public void setOrgans(String organs) {
        this.organs = organs;
    }
}
