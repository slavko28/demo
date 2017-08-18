package com.toptop.service;

import com.toptop.domain.Trailer;
import com.toptop.domain.enums.TrailerType;
import com.toptop.service.dto.TrailerDTO;

import java.util.List;

/**
 * Service Interface for managing Trailer entities.
 */
public interface TrailerService extends AbstractService<Trailer, Long, TrailerDTO> {

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
