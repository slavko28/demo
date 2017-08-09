package com.toptop.service.dto;

import com.toptop.domain.enums.EmployeeType;
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
public class CompanyEmployeeDTO implements Serializable {

    private Long id;

    private EmployeeType type;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String midName;

    @NotNull
    private String phoneNumber;

    @NotNull
    private CompanyDTO company;

    private String email;

    private String descriptionDetails;

    private String driverLicense;

    private String driverPassport;
}
