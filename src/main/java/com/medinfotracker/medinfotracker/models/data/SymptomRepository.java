package com.medinfotracker.medinfotracker.models.data;

import com.medinfotracker.medinfotracker.models.Symptoms;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends CrudRepository<Symptoms, Integer> {


}
