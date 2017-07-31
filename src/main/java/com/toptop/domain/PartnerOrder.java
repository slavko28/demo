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
import java.time.LocalDateTime;

/**
 * Created by slavkosoltys on 30.07.17.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PartnerOrder implements Serializable {

    private static final long serialVersionUID = 3610318214071648278L;

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private LocalDateTime orderDate;
    @NotNull
    private double budget;
    @NotNull
    private String downloadingPlace;
    @NotNull
    private String downloadingType;
    @NotNull
    private String uploadingPlace;

    private int volume;
    @NotNull
    private double weight;
    @NotNull
    private String description;

    @ManyToOne
    private Partner company;

    private boolean enabled;

}
