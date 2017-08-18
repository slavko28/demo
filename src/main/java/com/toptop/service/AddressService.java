package com.toptop.service;

import com.toptop.domain.Address;
import com.toptop.service.dto.AddressDTO;

import java.util.List;

/**
 * Service Interface for managing Address entities.
 */
public interface AddressService extends AbstractService<Address, Long, AddressDTO> {

    /**
     * Find all related (company and company orders) addresses by company id.
     *
     * @param id the company id
     * @return list of entities
     */
    List<AddressDTO> findAllByCompanyId(Long id);
}
