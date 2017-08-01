package com.toptop.service.dto;

import com.toptop.domain.enums.TrailerType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TrailerDTO implements Serializable {

    private Long id;

    @NotNull
    private String model;

    @NotNull
    private String licensePlate;

    @NotNull
    private int volume;

    @NotNull
    private int loadCapacity;

    private Long companyId;

    @NotNull
    private TrailerType type;
}