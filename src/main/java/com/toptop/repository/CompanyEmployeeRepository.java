package com.toptop.repository;

import com.toptop.domain.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployee, Long>{

    List<CompanyEmployee> findAllByCompanyId(Long id);
}
