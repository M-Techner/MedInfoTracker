package com.medinfotracker.medinfotracker.models;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import com.medinfotracker.medinfotracker.models.data.MappedSuperclass;

import javax.validation.constraints.*;
//import org.springframework.boot.SpringApplication;
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 3, max = 100, message = "Name must be between 3 and 50 characters")
    @NotBlank(message = "Name is required")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    public String toString() {
//        return "AbstractEntity{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AbstractEntity that = (AbstractEntity) o;
//        return id == that.id && Objects.equals(name, that.name);
//    }

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof AbstractEntity)) return false;
//        AbstractEntity that = (AbstractEntity) o;
//        return getId() == that.getId() && getName().equals(that.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
