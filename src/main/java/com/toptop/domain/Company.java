package com.toptop.domain;

import lombok.*;

import javax.persistence.*;
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
@Data
@Table(name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 8399254940472545214L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "company_cod")
    private int companyCod;

    @OneToMany
    @Column(name = "addresses")
    private Set<Address> addresses;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @Column(name = "orders")
    private Set<CompanyOrder> orders;
}
