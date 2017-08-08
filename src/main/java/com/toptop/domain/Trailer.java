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
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Trailer implements Serializable{

    private static final long serialVersionUID = -6752309351231662406L;

    @Id
    @GeneratedValue
    private Long id;
    private String model;
    private String licensePlate;
    private int volume;
    private int loadCapacity;
    @ManyToOne(optional = false)
    private Company company;
    @Enumerated(EnumType.STRING)
    private TrailerType type;
}
