package com.toptop.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Company.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Company implements Serializable {

    private static final long serialVersionUID = 8399254940472545214L;

    @Id
    @GeneratedValue
    private Long id;
    private String shortName;
    private String fullName;
    private int companyCod;

    @OneToMany
    private Set<Address> addresses;
    private String phone;

    @OneToMany(mappedBy = "company")
    private Set<CompanyOrder> orders;
}
