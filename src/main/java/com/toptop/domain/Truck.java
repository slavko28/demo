package com.toptop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by slavkosoltys on 30.07.17.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Truck implements Serializable{

    private static final long serialVersionUID = -5121608591459716179L;

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String model;

    @NotNull
    private String licensePlate;

    @ManyToOne(optional = false)
    private Carrier carrier;

    private int volume;

    private int loadCapacity;
}
