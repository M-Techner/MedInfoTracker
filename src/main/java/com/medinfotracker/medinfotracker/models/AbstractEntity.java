package com.medinfotracker.medinfotracker.models;


//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
import javax.validation.constraints.*;
//import java.util.Objects;
import java.util.*;
//import javax.persistence.MappedSuperclass;
import javax.persistence.*;
@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int userId;

//    getters and setters

    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

}