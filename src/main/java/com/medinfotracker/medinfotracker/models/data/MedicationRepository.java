package com.medinfotracker.medinfotracker.models.data;

import com.medinfotracker.medinfotracker.models.Medication;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepository extends CrudRepository<Medication, Integer> {

}
