package com.toptop.service.mapper;

import com.toptop.domain.Company;
import com.toptop.service.dto.CompanyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface CompanyMapper extends BaseMapper<Company, CompanyDTO> {

}
