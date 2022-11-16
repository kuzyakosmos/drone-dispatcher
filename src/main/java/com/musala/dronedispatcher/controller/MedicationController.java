package com.musala.dronedispatcher.controller;

import com.musala.dronedispatcher.dto.MedicationDto;
import com.musala.dronedispatcher.model.Drone;
import com.musala.dronedispatcher.model.Medication;
import com.musala.dronedispatcher.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/medications")
public class MedicationController {

    private final DroneService droneService;

    @GetMapping("/{serial-number}")
    public ResponseEntity<List<Medication>> checkBatteryLevel(@PathVariable(name = "serial-number") String serialNumber) {
        return ResponseEntity.ok(droneService.checkLoadedMedicationItems(serialNumber));
    }

    @PostMapping("/{serial-number}")
    public ResponseEntity<Iterable<Medication>> loadMedicationItems(@PathVariable(name = "serial-number") String serialNumber,
                                                                    @RequestBody MedicationDto medicationDto) {
        List<Medication> list = new ArrayList<>();

//        list.add(Medication.builder()
//                .code(medicationDto.getCode())
//                .name(medicationDto.getName())
//                .drone(new Drone(medicationDto.))
//                .weight(medicationDto.getWeight())
//                .build());
        return ResponseEntity.ok(droneService.load(new ArrayList<>(list)));
    }
}
