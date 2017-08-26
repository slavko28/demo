package com.toptop.repository;

import com.toptop.domain.CompanyEmployee;
import com.toptop.domain.enums.EmployeeType;
import com.toptop.service.dto.CompanyEmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployee, Long>{

    List<CompanyEmployee> findAllByCompanyId(Long id);

    List<CompanyEmployee> findAllByType(EmployeeType type);

    List<CompanyEmployee> findAllByCompanyIdAndType(Long companyId, EmployeeType employeeType);
}
