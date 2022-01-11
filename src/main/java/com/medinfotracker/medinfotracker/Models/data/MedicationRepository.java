package com.medinfotracker.medinfotracker.Models.data;

import com.medinfotracker.medinfotracker.Models.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
    @Transactional
public interface MedicationRepository extends CrudRepository<Medication, Integer> {

}

