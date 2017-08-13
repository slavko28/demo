package com.toptop.domain;

import com.toptop.domain.enums.TrailerType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Trailer.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "trailer")
public class Trailer extends BaseObject<Trailer> implements Serializable {

    private static final long serialVersionUID = -6752309351231662406L;

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
