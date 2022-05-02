package com.medinfotracker.medinfotracker.models;
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import com.medinfotracker.medinfotracker.models.*;
//import com.medinfotracker.medinfotracker.models.User;
//import com.medinfotracker.medinfotracker.models.data.*;
//import com.medinfotracker.medinfotracker.controllers.*;
//
//import javax.persistence.OneToMany;
//import javax.validation.constraints.NotNull;
//import java.util.Objects;
//
//@Entity
//public class Symptoms extends AbstractEntity {
//
//
//
//
//    private String startDate;
//    private String stopDate;
//    private String description;
////    @OneToMany
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    private String userName;
//    @NotNull
//    private String symptomName;
//
//    public User getUser() {
//        return user;
//    }
//
//    public Symptoms() {
//    }
//
//
//
//    public Symptoms(int id,User aUser, String aSymptomName, String aStartDate, String aStopDate, String aDescription, String aUserName) {
////        super(id, name);
//        super();
//        this.user = aUser;
//        this.symptomName = aSymptomName;
//        this.startDate = aStartDate;
//        this.stopDate = aStopDate;
//        this.description = aDescription;
//        this.userName = aUserName;
//    }
//
//    public String getStartDate() {
//        return this.startDate;
//    }
//
//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }
//
//
//    public String getStopDate() {
//        return this.stopDate;
//    }
//
//    public void setStopDate(String stopDate) {
//        this.stopDate = stopDate;
//    }
//
//    public String getDescription() {
//        return this.description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getUserName() {
//        return this.userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getSymptomName() {
//        return this.symptomName;
//    }
//
//    public void setSymptomName(String symptomName) {
//        this.symptomName = symptomName;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Symptoms that = (Symptoms) o;
//        return Objects.equals(symptomName, that.symptomName) && Objects.equals(startDate, that.startDate) && Objects.equals(stopDate, that.stopDate) && Objects.equals(description, that.description);
//    }
//}
//package com.medinfotracker.medinfotracker.models;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import javax.net.ssl.HandshakeCompletedEvent;
import com.medinfotracker.medinfotracker.models.AbstractEntity;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Symptoms extends AbstractEntity {
//    private String startDate;
//    private String stopDate;
//    private String description;
////    @OneToMany

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

//    private String userName;
    @NotNull
    private String symptomName;


//    private String symptomName;

    private String startDate;


    private String stopDate;


    private String description;

    public Symptoms(String aSymptomsName, String aStartDate, String aStopDate, String aDescription) {
        super();

        this.symptomName = aSymptomsName;
        this.startDate = aStartDate;
        this.stopDate = aStopDate;
        this.description = aDescription;
    }
    public Symptoms() {
    }
    public String getSymptomsName() {
        return symptomName;
    }
    public void setSymptomsName(String symptomName) {
        this.symptomName = symptomName;
    }
    public String getstartDate() {
        return startDate;
    }
    public void setstartDate(String startDate) {
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
   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptoms that = (Symptoms) o;
        return Objects.equals(symptomName, that.symptomName) && Objects.equals(startDate, that.startDate) && Objects.equals(stopDate, that.stopDate) && Objects.equals(description, that.description);
    }
    
}
