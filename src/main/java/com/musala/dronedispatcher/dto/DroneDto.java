package com.musala.dronedispatcher.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.musala.dronedispatcher.model.Drone} entity
 */
@Data
public class DroneDto implements Serializable {
    private final String serialNumber;
}