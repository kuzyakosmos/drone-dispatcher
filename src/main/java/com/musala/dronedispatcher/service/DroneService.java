package com.musala.dronedispatcher.service;

import com.musala.dronedispatcher.model.Drone;
import com.musala.dronedispatcher.model.Medication;

import java.util.List;

public interface DroneService {

    Drone register(Drone drone);

    Iterable<Medication> load(List<Medication> medications);

    List<Medication> checkLoadedMedicationItems(String serialNumber);

    Byte checkBattery(String serialNumber);

    List<String> checkAvailableDrones();
}
