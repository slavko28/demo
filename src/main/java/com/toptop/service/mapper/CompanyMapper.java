package com.toptop.service.mapper;

import com.toptop.domain.Company;
import com.toptop.service.dto.CompanyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO map(Company company);

    List<CompanyDTO> mapToCompanyDTOList(List<Company> companies);

    Company map(CompanyDTO companyDTO);

    List<Company> mapToCompanyList(List<CompanyDTO> companyDTOs);
}
