package com.musala.dronedispatcher.repository;

import com.musala.dronedispatcher.model.Drone;
import org.springframework.data.repository.CrudRepository;

public interface DroneRepository extends CrudRepository<Drone, String> {
}
