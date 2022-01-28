package com.medinfotracker.medinfotracker.Models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;



@Entity
public class Medication extends AbstractEntity {


    private String medicationName;



    private String dateStarted;


    private String prescribingPhysician;


    private String dosage;


    private String frequency;


    private String routeOfAdministration;


    private String refill;

    private String overTheCounter;




    public Medication(String aMedicationName, String aDateStarted, String aPrescribingPhysician, String aDosage, String aFrequency, String aRouteOfAdministration, String aRefill, String anOverTheCounter) {
        super();

        this.medicationName = aMedicationName;
        this.dateStarted = aDateStarted;
        this.prescribingPhysician = aPrescribingPhysician;
        this.dosage = aDosage;
        this.frequency = aFrequency;
        this.routeOfAdministration = aRouteOfAdministration;
        this.refill = aRefill;
        this.overTheCounter = anOverTheCounter;

    }
    public Medication() {

    }


    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getPrescribingPhysician() {
        return prescribingPhysician;
    }

    public void setPrescribingPhysician(String prescribingPhysician) {
        this.prescribingPhysician = prescribingPhysician;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dateStarted) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRouteOfAdministration() {
        return routeOfAdministration;
    }

    public void setRouteOfAdministration(String routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    public String getRefill() {
        return refill;
    }

    public void setRefill(String refill) {
        this.refill = refill;
    }

    public String getOverTheCounter() {
        return overTheCounter;
    }

    public void setOverTheCounter(String overTheCounter) {
        this.overTheCounter = overTheCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return Objects.equals(medicationName, that.medicationName) && Objects.equals(dateStarted, that.dateStarted) && Objects.equals(prescribingPhysician, that.prescribingPhysician) && Objects.equals(dosage, that.dosage) && Objects.equals(frequency, that.frequency) && Objects.equals(routeOfAdministration, that.routeOfAdministration) && Objects.equals(refill, that.refill) && Objects.equals(overTheCounter, that.overTheCounter);
    }
}

