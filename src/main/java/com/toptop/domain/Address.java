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
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address implements Serializable {

    private static final long serialVersionUID = 6153028233967159564L;

    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String zipCode;
    private String region;
    private String locality;
    private String street;
    private Integer number;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}
