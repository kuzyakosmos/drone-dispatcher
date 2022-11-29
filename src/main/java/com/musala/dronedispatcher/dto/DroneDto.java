package com.musala.dronedispatcher.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class DroneDto implements Serializable {

    private Long id;
    private String serialNumber;
    private String model;
    private short weightLimit;
    private byte batteryCapacity;
    private String state;

    public DroneDto(Long id, String serialNumber, String model, short weightLimit, byte batteryCapacity, String state) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }
}