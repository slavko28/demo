package com.toptop.domain;

import com.toptop.domain.enums.EmployeeType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Company employee.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class CompanyEmployee extends BaseObject implements Serializable {

    private static final long serialVersionUID = -8656867795070348248L;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    private String firstName;
    private String lastName;
    private String midName;
    private String phoneNumber;

    @ManyToOne(optional = false)
    private Company company;

    @Email(message = "*Please provide a valid Email")
    private String email;

    private String additionalDetails;
    private String driverLicense;
    private String driverPassport;
}
