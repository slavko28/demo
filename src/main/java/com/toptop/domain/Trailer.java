package com.toptop.domain;

import com.toptop.domain.enums.TrailerType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Trailer.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "trailer")
public class Trailer implements Serializable{

    private static final long serialVersionUID = -6752309351231662406L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "volume")
    private int volume;

    @Column(name = "load_capacity")
    private int loadCapacity;

    @ManyToOne(optional = false)
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TrailerType type;
}