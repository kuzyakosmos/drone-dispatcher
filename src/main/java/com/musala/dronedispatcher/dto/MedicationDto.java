package com.musala.dronedispatcher.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.musala.dronedispatcher.model.Medication} entity
 */
@Data
public class MedicationDto implements Serializable {
    private final String code;
    private final String name;
    private final short weight;
    private final String image;
    private final String drone;
}