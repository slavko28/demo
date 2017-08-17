package com.toptop.domain;

import com.toptop.domain.enums.AddressType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Address.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "address")
public class Address extends BaseObject implements Serializable {

    private static final long serialVersionUID = 6153028233967159564L;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "region")
    private String region;

    @Column(name = "locality")
    private String locality;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Integer number;

    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}
