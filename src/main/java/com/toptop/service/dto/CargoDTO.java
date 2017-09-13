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
public class CargoDTO  implements Serializable{

    private Long id;

    @NotNull
    private CompanyDTO company;

    private double volume;

    @NotNull
    private double weight;

    @NotNull
    private String description;

}
