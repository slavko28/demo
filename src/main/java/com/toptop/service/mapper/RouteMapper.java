package com.toptop.service.mapper;

import com.toptop.domain.Route;
import com.toptop.service.dto.RouteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = RoutePointMapper.class)
public interface RouteMapper {

    RouteDTO map(Route route);

    List<RouteDTO> mapToRouteDTOList(List<Route> routes);

    Route map(RouteDTO routeDTO);

    List<Route> mapToRouteList(List<RouteDTO> routeDTOs);
}
