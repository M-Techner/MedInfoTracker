package com.medinfotracker.medinfotracker.models;

import javax.persistence.Entity;
import javax.validation.constraints.*;
//import javax.validation.constraints.Size;
import java.util.*;

@Entity
class Symptoms extends AbstractEntity {
    @NotNull
    @Size(min=3, max=49)
    private String name;
    private Date startDate;
    private Date stopDate;
    private String description;

    public Symptoms() {
    }

//    public Symptoms(String aName, Date aStartDate, Date aStopDate, String aDescription) {
//        this.name = aName;
//        this.startDate = aStartDate;
//        this.stopDate = aStopDate;
//        this.description = aDescription;
//    }
//    


    public Symptoms(String aName, Date aStartDate, Date aStopDate, String aDescription) {
        super();
        this.name = aName;
        this.startDate = aStartDate;
        this.stopDate = aStopDate;
        this.description = aDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
