package com.toptop.service.mapper;

import com.toptop.domain.RoutePoint;
import com.toptop.service.dto.RoutePointDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface RoutePointMapper extends BaseMapper<RoutePoint, RoutePointDTO> {

}
