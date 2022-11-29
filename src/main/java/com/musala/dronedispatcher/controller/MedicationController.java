package com.musala.dronedispatcher.controller;

import com.musala.dronedispatcher.dto.MedicationDto;
import com.musala.dronedispatcher.model.Medication;
import com.musala.dronedispatcher.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/medications")
public class MedicationController {

    private final DroneService droneService;

    @GetMapping("/{serial-number}")
    public ResponseEntity<List<MedicationDto>> checkLoadedMedicationItems(@PathVariable(name = "serial-number") String serialNumber) {
        return ResponseEntity.ok(droneService.checkLoadedMedicationItems(serialNumber).stream().map(Medication::toDto).collect(Collectors.toList()));
    }

    @PostMapping("/{serial-number}")
    public ResponseEntity<List<MedicationDto>> loadMedicationItems(@PathVariable(name = "serial-number") String serialNumber,
                                                                   @RequestBody List<MedicationDto> medicationDtos) {
        List<Medication> medications = medicationDtos.stream().map(dto -> {
            Medication medication = new Medication();
            medication.setCode(dto.getCode());
            medication.setName(dto.getName());
            medication.setImage(dto.getImage());
            medication.setCode(dto.getCode());
            return medication;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(droneService.load(medications).stream().map(Medication::toDto).collect(Collectors.toList()));
    }
}