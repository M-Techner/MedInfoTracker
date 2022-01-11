package com.medinfotracker.medinfotracker.Models;

        import javax.persistence.Entity;
        import javax.persistence.JoinColumn;
        import javax.persistence.ManyToMany;
        import javax.persistence.ManyToOne;
        import javax.validation.constraints.NotBlank;
        import javax.validation.constraints.NotNull;
        import javax.validation.constraints.Size;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Objects;


@Entity
public class Medication extends AbstractEntity {

    @ManyToMany
    // still have ?
    @JoinColumn(name = "User")
    private final List<Medication> medications = new ArrayList<>();

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)

    private String medicationName;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)
    private String dateStarted;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)
    private String prescribingPhysician;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)
    private String dosage;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)
    private String frequency;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)
    private String routeOfAdministration;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)
    private String refill;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 60)
    private String overTheCounter;

    // Initialize the id and value fields.
    public Medication(String aMedicationName, String aDateStarted, String aPrescribingPhysician, String aDosage, String aFrequency, String aRouteOfAdminstration, String arefill, String anOverTheCounter) {
        super();
        this.medicationName = aMedicationName;
        this.dateStarted = aDateStarted;
        this.prescribingPhysician = aPrescribingPhysician;
        this.dosage = aDosage;
        this.frequency = aFrequency;
        this.routeOfAdministration = aRouteOfAdminstration;
        this.refill = arefill;
        this.overTheCounter = anOverTheCounter;

    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicatioName(String medicationName) {
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

