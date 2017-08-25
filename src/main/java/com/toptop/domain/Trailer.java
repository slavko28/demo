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
public class Trailer extends BaseObject implements Serializable {

    private static final long serialVersionUID = -6752309351231662406L;

    private String model;
    private String licensePlate;
    private int volume;
    private int loadCapacity;

    @ManyToOne(optional = false)
    private Company company;

    @Enumerated(EnumType.STRING)
    private TrailerType type;
}
