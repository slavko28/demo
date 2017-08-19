package com.toptop.service.impl;

import com.toptop.domain.Company;
import com.toptop.repository.CompanyRepository;
import com.toptop.service.CompanyService;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyServiceImpl extends TransactionService<Company, Long, CompanyMapper, CompanyDTO> implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    @Transactional(readOnly = true)
    public CompanyDTO findByOneByCompanyCod(int companyCod) {
        return getMapper().mapToDTO(companyRepository.findOneByCompanyCod(companyCod));
    }

    @Override
    protected JpaRepository<Company, Long> getRepository() {
        return companyRepository;
    }

    @Override
    protected CompanyMapper getMapper() {
        return companyMapper;
    }
}
