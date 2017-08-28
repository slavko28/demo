package com.toptop.service.impl;

import com.toptop.domain.CompanyEmployee;
import com.toptop.domain.enums.EmployeeType;
import com.toptop.repository.CompanyEmployeeRepository;
import com.toptop.service.CompanyEmployeeService;
import com.toptop.service.dto.CompanyEmployeeDTO;
import com.toptop.service.mapper.CompanyEmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyEmployeeServiceImpl extends TransactionService<CompanyEmployee, Long, CompanyEmployeeMapper, CompanyEmployeeDTO> implements CompanyEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CompanyEmployeeRepository employeeRepository;

    @Autowired
    private CompanyEmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompanyEmployeeDTO> findAllByCompanyId(Long id) {
        log.debug("Find all company employee by company id: {}", id);
        return getMapper().mapToDTOs(employeeRepository.findAllByCompanyId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyEmployeeDTO> findAllByType(EmployeeType type) {
        log.debug("Find all employees by type: {}", type);
        return getMapper().mapToDTOs(employeeRepository.findAllByType(type));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyEmployeeDTO> findAllByCompanyIdAndEmployeeType(Long companyId, EmployeeType employeeType) {
        log.debug("Find all employee by company id: {}, and employee type: {}", companyId, employeeType);
        return getMapper().mapToDTOs(employeeRepository.findAllByCompanyIdAndType(companyId, employeeType));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(CompanyEmployeeDTO employeeDTO) throws IllegalArgumentException {
        log.debug("Check if company employee is exits: {}", employeeDTO);
        return getRepository().exists(employeeDTO.getId());
    }

    @Override
    protected JpaRepository<CompanyEmployee, Long> getRepository() {
        return employeeRepository;
    }

    @Override
    protected CompanyEmployeeMapper getMapper() {
        return employeeMapper;
    }
}
