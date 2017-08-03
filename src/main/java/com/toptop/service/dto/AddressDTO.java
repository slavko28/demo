package com.toptop.service.dto;

import com.toptop.domain.enums.AddressType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AddressDTO implements Serializable{

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
