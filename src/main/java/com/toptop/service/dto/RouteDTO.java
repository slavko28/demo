package com.toptop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RouteDTO implements Serializable {

    private Long id;

    private List<RoutePointDTO> routePoints;

    private String additionalInformation;
}
