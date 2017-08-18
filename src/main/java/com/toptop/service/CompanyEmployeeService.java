package com.toptop.service;

import com.toptop.domain.CompanyEmployee;
import com.toptop.service.dto.CompanyEmployeeDTO;

import java.util.List;

/**
 * Service Interface for managing Company's employee entities.
 */
public interface CompanyEmployeeService extends AbstractService<CompanyEmployee, Long, CompanyEmployeeDTO> {

    /**
     * Find all employee by Company id.
     *
     * @return the list af entities
     */
    List<CompanyEmployeeDTO> findAllByCompanyId(Long id);
}
