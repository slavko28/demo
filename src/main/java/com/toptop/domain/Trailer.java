package com.toptop.domain;

import com.toptop.domain.enums.TrailerType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
public class Trailer implements Serializable{

    private static final long serialVersionUID = -6752309351231662406L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String model;

    @NotNull
    private String licensePlate;

    @NotNull
    private int volume;

    @NotNull
    private int loadCapacity;

    @ManyToOne(optional = false)
    private Company company;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TrailerType type;
}
