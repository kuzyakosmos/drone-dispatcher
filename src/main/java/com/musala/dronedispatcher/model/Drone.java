package com.musala.dronedispatcher.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
//@ToString
@RequiredArgsConstructor
@Table(name = "drones")
public class Drone {
    @Id
    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private Model model;

    private short weightLimit;

    private byte batteryCapacity;

    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(targetEntity = Medication.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "drone")
    private List<Medication> medications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Drone drone = (Drone) o;
        return serialNumber != null && Objects.equals(serialNumber, drone.serialNumber);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
