package com.toptop.service.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @NotNull
    private Long companyId;

    private int volume;

    private int loadCapacity;
}
