package com.musala.dronedispatcher.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "medications")
public class Medication extends Load {
    @Id
    @Column(nullable = false)
    private String code;

    private String name;

    private short weight;

    //todo
    private String image;

    @ManyToOne
    @JoinColumn
    private Drone drone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medication that = (Medication) o;
        return code != null && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
