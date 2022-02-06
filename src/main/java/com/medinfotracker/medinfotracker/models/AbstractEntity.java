package com.medinfotracker.medinfotracker.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;
@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

//    @Size(min = 3, max = 100, message = "Name must be between 3 and 50 characters")
//    @NotBlank(message = "Name is required")
    private String name;

    public AbstractEntity() {
    }

    public AbstractEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (getId() != that.getId()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }


    //    @Override
//    public int hashCode() {
//        int result = getId();
//        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
//        return result;
//    }
    //    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
//
////public int getId() { return id; }
////
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        AbstractEntity that = (AbstractEntity) o;
////        return id == that.id;
////    }
////
////    @Override
////    public int hashCode() {
////        return Objects.hash(id);
////    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AbstractEntity that = (AbstractEntity) o;
//        return id == that.id;
//    }
//
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}