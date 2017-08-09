package com.toptop.service.mapper;

import com.toptop.domain.Route;
import com.toptop.service.dto.RouteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface RoutePointMapper {

    RouteDTO.RoutePointDTO map(Route.RoutePoint routePoint);

    List<RouteDTO.RoutePointDTO> mapToRoutePointDTOList(List<Route.RoutePoint> routePoints);

    Route.RoutePoint map(RouteDTO.RoutePointDTO routePointDTO);

    List<Route.RoutePoint> mapToRoutePointList(List<RouteDTO.RoutePointDTO> routePointDTOs);
}
