package com.toptop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyDTO implements Serializable {

    private Long id;

    @NotNull
    private String shortName;

    @NotNull
    private String fullName;

    @NotNull
    private Long companyCod; // TODO: must be validation of allowed number of numeric characters

    @NotNull
    private Set<AddressDTO> address;
}
