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

    @NotNull
    private String country;
    private String zipCode;

    @NotNull
    private String region;

    @NotNull
    private String locality;
    private String street;
    private Integer number;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

}
