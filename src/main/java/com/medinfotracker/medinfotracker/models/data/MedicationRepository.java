package com.medinfotracker.medinfotracker.models.data;

import com.medinfotracker.medinfotracker.models.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface MedicationRepository extends CrudRepository<Medication, Integer> {
    Medication findById(int userId);
}