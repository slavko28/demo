package com.toptop.service.impl;

import com.toptop.domain.Company;
import com.toptop.repository.CompanyRepository;
import com.toptop.service.CompanyService;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.mapper.CompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl extends TransactionService<Company, Long, CompanyMapper, CompanyDTO> implements CompanyService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;


    @Override
    @Transactional(readOnly = true)
    public Optional<CompanyDTO> findByOneByCompanyCod(Long companyCod) {
        LOG.debug("Find company cod: {}", companyCod);
        Company company = companyRepository.findOneByCompanyCod(companyCod);
        return Optional.ofNullable(getMapper().mapToDTO(company));
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
