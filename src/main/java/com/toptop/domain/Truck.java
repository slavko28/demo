package com.toptop.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Truck.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Truck implements Serializable{

    private static final long serialVersionUID = -5121608591459716179L;

    @Id
    @GeneratedValue
    private int id;
    private String model;
    private String licensePlate;
    @ManyToOne(optional = false)
    private Company company;
    private int volume;
    private int loadCapacity;
}
