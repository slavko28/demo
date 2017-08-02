package com.toptop.service.mapper;

import com.toptop.domain.Company;
import com.toptop.service.dto.CompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {


    CompanyDTO map(Company company);

    List<CompanyDTO> mapToCompanyDTOList(List<Company> companies);

    @Mapping(target = "orders", ignore = true)
    Company map(CompanyDTO companyDTO);

    List<Company> mapToCompanyList(List<CompanyDTO> companyDTOs);
}
