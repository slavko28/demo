package com.toptop.service.dto;

import com.toptop.domain.enums.TrailerType;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
    private Long companyId;

    @NotNull
    private TrailerType type;
}