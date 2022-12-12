package com.musala.dronedispatcher.repository;

import com.musala.dronedispatcher.model.Drone;
import com.musala.dronedispatcher.model.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DroneRepository extends CrudRepository<Drone, String> {
    List<Drone> findByStateIs(State state);
}
