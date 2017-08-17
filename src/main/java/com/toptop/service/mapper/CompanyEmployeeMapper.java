package com.toptop.service.mapper;

import com.toptop.domain.CompanyEmployee;
import com.toptop.service.dto.CompanyEmployeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface CompanyEmployeeMapper extends BaseMapper<CompanyEmployee, CompanyEmployeeDTO> {


}
