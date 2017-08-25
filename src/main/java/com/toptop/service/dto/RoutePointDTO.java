package com.toptop.service.dto;

import com.toptop.domain.enums.RouteActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoutePointDTO implements Serializable {

    private Long id;

    private AddressDTO address;

    private RouteActivityType type;
}

