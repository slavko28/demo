package com.toptop.service.mapper;

import com.toptop.domain.Cargo;
import com.toptop.service.dto.CargoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface CargoMapper extends BaseMapper<Cargo, CargoDTO> {

}
