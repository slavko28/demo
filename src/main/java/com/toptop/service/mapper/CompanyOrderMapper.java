package com.toptop.service.mapper;

import com.toptop.domain.CompanyOrder;
import com.toptop.service.dto.CompanyOrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoutePointMapper.class, CargoMapper.class, CompanyMapper.class, CompanyEmployeeMapper.class})
public interface CompanyOrderMapper extends BaseMapper<CompanyOrder, CompanyOrderDTO> {

}
