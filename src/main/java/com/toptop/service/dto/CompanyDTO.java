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
public class CompanyDTO implements Serializable {

    private Long id;

    @NotNull
    private String shortName;

    @NotNull
    private String fullName;

    @NotNull
    private int companyCod; // TODO: must be validation of allowed number of numeric characters

    @NotNull
    private String address;

    @NotNull
    private String phone;
}
