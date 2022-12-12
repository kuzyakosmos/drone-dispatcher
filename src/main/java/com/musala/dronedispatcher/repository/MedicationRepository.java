package com.musala.dronedispatcher.repository;

import com.musala.dronedispatcher.model.Medication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicationRepository extends CrudRepository<Medication, Integer> {
    @Query("FROM Medication m LEFT JOIN FETCH m.drone WHERE m.drone.serialNumber = :serialNumber")
    List<Medication> findByDroneIs(String serialNumber);
}
