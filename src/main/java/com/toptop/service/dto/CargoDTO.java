package com.toptop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CargoDTO  implements Serializable{

    private Long id;

    private CompanyDTO company;

    private double volume;

    private double weight;

    private String description;

}
