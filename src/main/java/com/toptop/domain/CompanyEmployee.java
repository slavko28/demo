package com.toptop.domain;

import com.toptop.domain.enums.EmployeeType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Company employee.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CompanyEmployee implements Serializable {

    private static final long serialVersionUID = -8656867795070348248L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String midName;

    @NotNull
    private String phoneNumber;

    @ManyToOne(optional = false)
    private Company company;

    private String email;

    private String descriptionDetails;

    private String license;

    private String passport;

}
