package com.toptop.service.mapper;

import com.toptop.domain.Route;
import com.toptop.service.dto.RouteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoutePointMapper.class)
public interface RouteMapper extends BaseMapper<Route, RouteDTO> {

}
