package com.musala.dronedispatcher.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.musala.dronedispatcher.dto.MedicationDto;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "medications")
public class Medication{
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    private String code;

    @Setter
    private String name;

    @Setter
    private short weight;

    @Setter
    private String image;

    @ManyToOne
    @JoinColumn(name = "drone")
    @JsonIgnore
    private Drone drone;

    public MedicationDto toDto() {
        return new MedicationDto(id, code, name, weight, image, drone.getId());
    }
}
