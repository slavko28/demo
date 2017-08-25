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
public class Address extends BaseObject implements Serializable {

    private static final long serialVersionUID = 6153028233967159564L;

    private String country;
    private String zipCode;
    private String region;
    private String locality;
    private String street;
    private Integer number;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}
