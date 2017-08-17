package com.toptop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Company.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "company")
public class Company extends BaseObject implements Serializable {

    private static final long serialVersionUID = 8399254940472545214L;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "company_cod")
    private int companyCod;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Address> address;
}
