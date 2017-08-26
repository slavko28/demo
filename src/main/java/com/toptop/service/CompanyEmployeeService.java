package com.toptop.service;

import com.toptop.domain.CompanyEmployee;
import com.toptop.domain.enums.EmployeeType;
import com.toptop.rest.CompanyEmployeeController;
import com.toptop.service.dto.CompanyEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Service Interface for managing Company's employee entities.
 */
public interface CompanyEmployeeService extends AbstractService<CompanyEmployee, Long, CompanyEmployeeDTO> {

    /**
     * Find all employee by Company id.
     *
     * @return the list of entities
     */
    List<CompanyEmployeeDTO> findAllByCompanyId(Long id);

    /**
     * Find all employees by type.
     *
     * @param type the employee type
     * @return the list of entities
     */
    List<CompanyEmployeeDTO> findAllByType(EmployeeType type);

    /**
     * Find all employees by company id znd employee type.
     *
     * @param companyId the company id
     * @param employeeType the employee type
     * @return the list of entities
     */
    List<CompanyEmployeeDTO> findAllByCompanyIdAndEmployeeType(Long companyId, EmployeeType employeeType);
}
