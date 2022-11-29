package com.musala.dronedispatcher.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class MedicationDto implements Serializable {
    private Long id;
    private String code;
    private String name;
    private short weight;
    private String image;
    private Long drone;

    public MedicationDto(Long id, String code, String name, short weight, String image, Long drone) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.image = image;
        this.drone = drone;
    }
}