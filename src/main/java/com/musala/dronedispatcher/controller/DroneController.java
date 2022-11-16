package com.musala.dronedispatcher.controller;

import com.musala.dronedispatcher.model.Drone;
import com.musala.dronedispatcher.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/drones")
public class DroneController {

    private final DroneService droneService;

    @PostMapping
    public ResponseEntity<Drone> register(@RequestBody Drone drone) {
        return ResponseEntity.ok(droneService.register(drone));
    }

    @GetMapping("/{serial-number}")
    public ResponseEntity<Byte> checkBatteryLevel(@PathVariable(name = "serial-number") String serialNumber) {
        return ResponseEntity.ok(droneService.checkBattery(serialNumber));
    }
}
