package com.toptop.service;

import com.toptop.domain.enums.TrailerType;
import com.toptop.service.dto.TrailerDTO;
import com.toptop.service.dto.TruckDTO;

import java.util.List;

/**
 * Service Interface for managing Truck entities.
 */
public interface TruckService {

    /**
     * Save new entity.
     *
     * @param truckDTO the entity to save
     * @return the saved entity
     */
    TruckDTO save(TruckDTO truckDTO);

    /**
     * Find entity by Id.
     *
     * @param id the entity id
     * @return the entity
     */
    TruckDTO findOne(Long id);

    /**
     * Find all entities.
     *
     * @return the list of entities
     */
    List<TruckDTO> findAll();

    /**
     * Find all entities by Company id.
     *
     * @param id the Company id
     * @return the list of entities
     */
    List<TruckDTO> findAllByCompanyId(Long id);
}
