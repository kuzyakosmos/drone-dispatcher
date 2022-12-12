package com.musala.dronedispatcher.model;

import com.musala.dronedispatcher.dto.DroneDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drones")
public class Drone {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String serialNumber;

    @Setter
    @Enumerated(EnumType.STRING)
    private Model model;

    @Setter
    private short weightLimit;

    @Setter
    private byte batteryCapacity = 100;

    @Setter
    @Enumerated(EnumType.STRING)
    private State state = State.IDLE;

    @OneToMany(targetEntity = Medication.class, cascade = CascadeType.ALL, mappedBy = "drone")
    private List<Medication> medications;

    public DroneDto toDto() {
        return new DroneDto (id, serialNumber, model.name(), weightLimit, batteryCapacity, state.name());
    }
}
