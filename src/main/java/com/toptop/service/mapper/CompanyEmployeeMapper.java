package com.toptop.service.mapper;

import com.toptop.domain.CompanyEmployee;
import com.toptop.service.dto.CompanyEmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface CompanyEmployeeMapper {

    @Mapping(source = "company.id", target = "companyId")
    CompanyEmployeeDTO map(CompanyEmployee employee);

    List<CompanyEmployeeDTO> mapToCompanyEmployeeDTOList(List<CompanyEmployee> employees);

    @Mapping(source = "companyId", target = "company.id")
    CompanyEmployee map(CompanyEmployeeDTO employeeDTO);

    List<CompanyEmployee> mapToCompanyEmployeeList(List<CompanyEmployeeDTO> employeesDTO);
}
