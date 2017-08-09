package com.toptop.domain;

import com.toptop.domain.enums.AddressType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Address.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "address")
public class Address implements Serializable {

    private static final long serialVersionUID = 6153028233967159564L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

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
