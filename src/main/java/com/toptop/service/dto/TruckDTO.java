package com.toptop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TruckDTO implements Serializable {

    private Long id;

    @NotNull
    private String model;

    @NotNull
    private String licensePlate;

    @NotNull
    private CompanyDTO company;

    private int volume;

    private int loadCapacity;
}
