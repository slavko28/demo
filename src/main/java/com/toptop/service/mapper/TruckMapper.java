package com.toptop.service.mapper;

import com.toptop.domain.Truck;
import com.toptop.service.dto.TruckDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface TruckMapper extends BaseMapper<Truck, TruckDTO> {

}
