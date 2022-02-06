package com.medinfotracker.medinfotracker.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Conditions extends AbstractEntity {
    @NotNull
    @Size(min=3, max=49)
    private String name;
    private String primarySystem;
    private String diagnosingDr;
    private String drSpecialty;
    private Date diagnosisDate;
    private String disorderStatus;
    private String description;

    public Conditions() {
    }

    public Conditions(String name, String primarySystem, String diagnosingDr, String drSpecialty, Date diagnosisDate, String disorderStatus, String description) {
        this.name = name;
        this.primarySystem = primarySystem;
        this.diagnosingDr = diagnosingDr;
        this.drSpecialty = drSpecialty;
        this.diagnosisDate = diagnosisDate;
        this.disorderStatus = disorderStatus;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getPrimarySystem() {
        return primarySystem;
    }

    public void setPrimarySystem(String primarySystem) {
        this.primarySystem = primarySystem;
    }

    public String getDiagnosingDr() {
        return diagnosingDr;
    }

    public void setDiagnosingDr(String diagnosingDr) {
        this.diagnosingDr = diagnosingDr;
    }

    public String getDrSpecialty() {
        return drSpecialty;
    }

    public void setDrSpecialty(String drSpecialty) {
        this.drSpecialty = drSpecialty;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getDisorderStatus() {
        return disorderStatus;
    }

    public void setDisorderStatus(String disorderStatus) {
        this.disorderStatus = disorderStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
