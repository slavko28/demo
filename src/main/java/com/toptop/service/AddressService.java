package com.toptop.service;

import com.toptop.service.dto.AddressDTO;

import java.util.List;

/**
 * Service Interface for managing Address entities.
 */
public interface AddressService {

    /**
     * Save new entity.
     *
     * @param addressDTO the address to save
     * @return the saved entity
     */
    AddressDTO save(AddressDTO addressDTO);

    /**
     * Find address by Id.
     *
     * @param id the address id
     * @return the entity
     */
    AddressDTO findOne(Long id);

    /**
     * Find all addresses.
     *
     * @return the list of entities
     */
    List<AddressDTO> findAll();
}
