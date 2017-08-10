package com.toptop.service.dto;

import com.toptop.domain.enums.RouteActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoutePointDTO {

    private AddressDTO address;

    private RouteActivityType type;
}

