package com.toptop.service.dto;

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
public class TruckDTO implements Serializable {

    private int id;

    @NotNull
    private String model;

    @NotNull
    private String licensePlate;

    private Long companyId;

    private int volume;

    private int loadCapacity;
}
