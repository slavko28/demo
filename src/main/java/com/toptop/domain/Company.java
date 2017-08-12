package com.toptop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Address> address;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<CompanyOrder> orders;
}
