package com.toptop.service;

import com.toptop.domain.Company;
import com.toptop.service.dto.CompanyDTO;

import java.util.Optional;

/**
 * Service Interface for managing Company entities.
 */
public interface CompanyService extends AbstractService<Company, Long, CompanyDTO> {

    /**
     * Find entity by Company cod.
     *
     * @param companyCod the Company cod
     * @return the entity
     */
    Optional<CompanyDTO> findOneByCompanyCod(Long companyCod);

}
