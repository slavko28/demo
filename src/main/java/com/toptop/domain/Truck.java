package com.toptop.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Truck.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "truck")
public class Truck implements Serializable{

    private static final long serialVersionUID = -5121608591459716179L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "license_plate")
    private String licensePlate;

    @ManyToOne(optional = false)
    private Company company;

    @Column(name = "volume")
    private int volume;

    @Column(name = "load_capacity")
    private int loadCapacity;
}