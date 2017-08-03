package com.toptop.service;

import com.toptop.domain.enums.TrailerType;
import com.toptop.service.dto.TrailerDTO;

import java.util.List;

/**
 * Service Interface for managing Trailer entities.
 */
public interface TrailerService {

    /**
     * Save new entity.
     *
     * @param trailerDTO the entity to save
     * @return the saved entity
     */
    TrailerDTO save(TrailerDTO trailerDTO);

    /**
     * Find entity by Id.
     *
     * @param id the entity id
     * @return the entity
     */
    TrailerDTO findOne(Long id);

    /**
     * Find all entities.
     *
     * @return the list of entities
     */
    List<TrailerDTO> findAll();

    /**
     * Find all entities by trailer type.
     *
     * @param trailerType the trailer type
     * @return the list of entities
     */
    List<TrailerDTO> findAllByType(TrailerType trailerType);

    /**
     * Find all entities by Company id.
     *
     * @param id the Company id
     * @return the list of entities
     */
    List<TrailerDTO> findAllByCompanyId(Long id);
}
