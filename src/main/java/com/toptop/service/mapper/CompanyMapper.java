package com.toptop.service.mapper;

import com.toptop.domain.Company;
import com.toptop.service.dto.CompanyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends BaseMapper<Company, CompanyDTO> {

}
