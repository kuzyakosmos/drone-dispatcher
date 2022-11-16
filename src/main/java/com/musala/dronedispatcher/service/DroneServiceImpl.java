package com.musala.dronedispatcher.service;

import com.musala.dronedispatcher.model.Drone;
import com.musala.dronedispatcher.model.Medication;
import com.musala.dronedispatcher.repository.DroneRepository;
import com.musala.dronedispatcher.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;

    private final MedicationRepository medicationRepository;

    @Override
    public Drone register(Drone drone) {
        return droneRepository.save(drone);
    }

    @Override
    public Iterable<Medication> load(List<Medication> medications) {
        return medicationRepository.saveAll(medications);
    }

    @Override
    public List<Medication> checkLoadedMedicationItems(String serialNumber) {
        Drone drone = droneRepository.findById(serialNumber).get();
        List<Medication> medications = drone.getMedications().stream().collect(Collectors.toList());
        return medications;
    }

    @Override
    public Byte checkBattery(String serialNumber) {
        droneRepository.findById(serialNumber);
        return droneRepository.findById(serialNumber)
                .orElseThrow(() -> new RuntimeException(String.format("Drone with serial number = %s not found", serialNumber)))
                .getBatteryCapacity();
    }

    @Override
    public List<Drone> checkAvailableDrones() {
        return null;
    }
}
