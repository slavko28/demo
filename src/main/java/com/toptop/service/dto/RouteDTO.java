package com.toptop.service.dto;

import com.toptop.domain.enums.RouteActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RouteDTO implements Serializable {

    private Long id;

    private LinkedList<RoutePointDTO> routePoints;

    @Data
    @NoArgsConstructor
    public static class RoutePointDTO {
        private AddressDTO address;
        private RouteActivityType type;
    }
}
