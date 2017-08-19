package com.toptop.service.impl;

import com.toptop.domain.CompanyEmployee;
import com.toptop.repository.CompanyEmployeeRepository;
import com.toptop.service.CompanyEmployeeService;
import com.toptop.service.dto.CompanyEmployeeDTO;
import com.toptop.service.mapper.CompanyEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyEmployeeServiceImpl extends TransactionService<CompanyEmployee, Long, CompanyEmployeeMapper, CompanyEmployeeDTO> implements CompanyEmployeeService {

    @Autowired
    private CompanyEmployeeRepository employeeRepository;

    @Autowired
    private CompanyEmployeeMapper employeeMapper;


    @Override
    @Transactional(readOnly = true)
    public List<CompanyEmployeeDTO> findAllByCompanyId(Long id) {
        return getMapper().mapToDTOs(employeeRepository.findAllByCompanyId(id));
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
