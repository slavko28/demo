package com.toptop.service;

import com.toptop.domain.Truck;
import com.toptop.service.dto.TruckDTO;

import java.util.List;

/**
 * Service Interface for managing Truck entities.
 */
public interface TruckService extends AbstractService<Truck, Long, TruckDTO> {

    /**
     * Find all entities by Company id.
     *
     * @param id the Company id
     * @return the list of entities
     */
    List<TruckDTO> findAllByCompanyId(Long id);
}
