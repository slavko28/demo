package com.toptop.service;

import com.toptop.service.dto.CompanyDTO;

import java.util.List;

/**
 * Service Interface for managing Company entities.
 */
public interface CompanyService {

    /**
     * Save new entity.
     *
     * @param companyDTO the entity to save
     * @return the saved entity
     */
    CompanyDTO save(CompanyDTO companyDTO);

    /**
     * Find Company by Id.
     *
     * @param id the Company Id
     * @return the entity
     */
    CompanyDTO findOne(Long id);

    /**
     * Find all Companies.
     *
     * @return the list af entities
     */
    List<CompanyDTO> findAll();
}
