package com.toptop.repository;

import com.toptop.domain.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<CompanyEmployee, Long>{
}
