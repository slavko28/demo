package com.toptop.service.mapper;

import com.toptop.domain.CompanyEmployee;
import com.toptop.service.dto.CompanyEmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface CompanyEmployeeMapper {

    CompanyEmployeeDTO map(CompanyEmployee employee);

    List<CompanyEmployeeDTO> mapToCompanyEmployeeDTOList(List<CompanyEmployee> employees);

    CompanyEmployee map(CompanyEmployeeDTO employeeDTO);

    List<CompanyEmployee> mapToCompanyEmployeeList(List<CompanyEmployeeDTO> employeesDTO);
}
