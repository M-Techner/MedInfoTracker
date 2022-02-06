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
    /**
     * get and set
     */
    public int getId() {
        return id;
    }


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