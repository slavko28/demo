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
@Table(name = "company_employee")
public class CompanyEmployee extends BaseObject implements Serializable {

    private static final long serialVersionUID = -8656867795070348248L;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EmployeeType type;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(optional = false)
    private Company company;

    @Email(message = "*Please provide a valid Email")
    @Column(name = "email")
    private String email;

    @Column(name = "additional_details")
    private String additionalDetails;

    @Column(name = "driver_license")
    private String driverLicense;

    @Column(name = "driver_passport")
    private String driverPassport;
}
