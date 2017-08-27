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
public class Company extends BaseObject implements Serializable {

    private static final long serialVersionUID = 8399254940472545214L;

    private String shortName;
    private String fullName;
    private Long companyCod;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Address> address;
}
