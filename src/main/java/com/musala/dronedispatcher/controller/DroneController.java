package com.musala.dronedispatcher.controller;

import com.musala.dronedispatcher.dto.DroneDto;
import com.musala.dronedispatcher.model.Drone;
import com.musala.dronedispatcher.model.Model;
import com.musala.dronedispatcher.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.EnumUtils.getEnum;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/drones")
public class DroneController {

    private final DroneService droneService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody DroneDto droneDto) {
        if (droneDto.getSerialNumber().length() > 100) {
            return ResponseEntity.ok("Maximum serial number size is 100 characters");
        }
        if (droneDto.getWeightLimit() > 500) {
            return ResponseEntity.ok("Maximum weightlimit is 500 grams");
        }
        if (!EnumUtils.isValidEnum(Model.class, droneDto.getModel())) {
            return ResponseEntity.ok("Available models are: LIGHTWEIGHT, MIDDLEWEIGHT, CRUISERWEIGHT, HEAVYWEIGHT");
        }

        Drone drone = new Drone();
        drone.setSerialNumber(droneDto.getSerialNumber());
        drone.setModel(getEnum(Model.class, droneDto.getModel()));
        drone.setWeightLimit(droneDto.getWeightLimit());

        return ResponseEntity.ok(droneService.register(drone).getId());
    }

    @GetMapping("/battery/{serial-number}")
    public ResponseEntity<Byte> checkBatteryLevel(@PathVariable(name = "serial-number") String serialNumber) {
        return ResponseEntity.ok(droneService.checkBattery(serialNumber));
    }

    @GetMapping
    public ResponseEntity<List<Long>> checkAvailableDrones() {
        return ResponseEntity.ok(droneService.checkAvailableDrones());
    }
}
