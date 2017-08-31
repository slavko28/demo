package com.toptop.service.dto;

import com.toptop.domain.enums.RouteActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoutePointDTO implements Serializable {

    private Long id;

    @NotNull
    private AddressDTO address;

    @NotNull
    private RouteActivityType type;
}

