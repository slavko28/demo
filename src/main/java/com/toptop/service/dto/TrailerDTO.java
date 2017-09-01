package com.toptop.service.dto;

import com.toptop.domain.enums.TrailerType;
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
public class TrailerDTO implements Serializable {

    private Long id;

    private String model;

    @NotNull
    private String licensePlate;

    @NotNull
    private int volume;

    @NotNull
    private int loadCapacity;

    @NotNull
    private CompanyDTO company;

    @NotNull
    private TrailerType type;
}
