package com.musala.dronedispatcher.service;

import com.musala.dronedispatcher.model.Drone;
import com.musala.dronedispatcher.model.Medication;
import com.musala.dronedispatcher.model.State;
import com.musala.dronedispatcher.repository.DroneRepository;
import com.musala.dronedispatcher.repository.MedicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public List<Medication> load(List<Medication> medications) {
        return StreamSupport.stream(medicationRepository.saveAll(medications).spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Medication> checkLoadedMedicationItems(String serialNumber) {
        return medicationRepository.findByDroneIs(serialNumber);
    }

    @Override
    public Byte checkBattery(String serialNumber) {
        Optional<Drone> optionalDrone = droneRepository.findById(serialNumber);
        if (optionalDrone.isPresent()) {
            return optionalDrone.get().toDto().getBatteryCapacity();
        } else {
            throw new RuntimeException(String.format("Drone with serial number = %s not found", serialNumber));
        }
    }

    @Override
    public List<Long> checkAvailableDrones() {
        return droneRepository.findByStateIs(State.LOADING).stream().map(Drone::getId).collect(Collectors.toList());
    }
}
