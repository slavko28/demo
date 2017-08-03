package com.toptop.service;

import com.toptop.service.dto.CompanyEmployeeDTO;

import java.util.List;

/**
 * Service Interface for managing Company's employee entities.
 */
public interface CompanyEmployeeService {

    /**
     * Save new entity.
     *
     * @param employeeDTO the entity to save
     * @return the saved entity
     */
    CompanyEmployeeDTO save(CompanyEmployeeDTO employeeDTO);

    /**
     * Find Company's employee by Id.
     *
     * @param id the Company's employee Id
     * @return the entity
     */
    CompanyEmployeeDTO findOne(Long id);

    /**
     * Find all employee by Company id.
     *
     * @return the list af entities
     */
    List<CompanyEmployeeDTO> findAllByCompanyId(Long id);
}
