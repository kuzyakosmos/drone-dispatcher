package com.musala.dronedispatcher.job;

import com.musala.dronedispatcher.dto.DroneDto;
import com.musala.dronedispatcher.model.State;
import com.musala.dronedispatcher.repository.DroneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BatteryCheckJob {

    private static Logger audit = LoggerFactory.getLogger("audit-log");

    @Autowired
    private DroneRepository droneRepository;

    @Scheduled(fixedDelayString = "${scheduler.fixedDelay}")
    public void checkBattery() {
        droneRepository.findAll().forEach(d -> {
            DroneDto droneDto = d.toDto();
            audit.info(String.format("Drone id=%s battery level is %s", d.getId(), droneDto.getBatteryCapacity()));
            if (droneDto.getBatteryCapacity() < 25) {
                d.setState(State.IDLE);
                droneRepository.save(d);
            }
        });
    }
}
