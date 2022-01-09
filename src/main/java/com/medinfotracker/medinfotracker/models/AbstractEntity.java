package com.medinfotracker.medinfotracker.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.*;
//import java.util.Objects;
import java.util.*;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 3, max = 100, message = "Name must be between 3 and 50 characters")
    @NotBlank(message = "Name is required")
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}