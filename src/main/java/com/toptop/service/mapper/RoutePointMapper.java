package com.toptop.service.mapper;

import com.toptop.domain.RoutePoint;
import com.toptop.service.dto.RoutePointDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface RoutePointMapper {

    RoutePointDTO map(RoutePoint routePoint);

    List<RoutePointDTO> mapToRoutePointDTOList(List<RoutePoint> routePoints);

    RoutePoint map(RoutePointDTO routePointDTO);

    List<RoutePoint> mapToRoutePointList(List<RoutePointDTO> routePointDTOs);
}
