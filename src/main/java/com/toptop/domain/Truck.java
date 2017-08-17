package com.toptop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Truck.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "truck")
public class Truck extends BaseObject implements Serializable {

    private static final long serialVersionUID = -5121608591459716179L;

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
