package com.toptop.service.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TruckDTO implements Serializable {

    private int id;

    @NotNull
    private String model;

    @NotNull
    private String licensePlate;

    @NotNull
    private CompanyDTO company;

    private int volume;

    private int loadCapacity;
}
