package com.toptop.service.dto;

import com.toptop.domain.Company;
import com.toptop.domain.enums.EmployeeType;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
    private String companyId;

    private String email;

    private String descriptionDetails;

    private String license;

    private String passport;
}
