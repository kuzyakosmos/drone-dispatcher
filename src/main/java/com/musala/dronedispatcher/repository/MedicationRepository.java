package com.musala.dronedispatcher.repository;

import com.musala.dronedispatcher.model.Medication;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicationRepository extends CrudRepository<Medication, Integer> {
    List<Medication> findByDroneIs(String serialNumber);
}
