package com.toptop.service;

import com.toptop.domain.Cargo;
import com.toptop.service.dto.CargoDTO;

import java.util.List;

/**
 * Service Interface for managing Cargo entities.
 */
public interface CargoService extends AbstractService<Cargo, Long, CargoDTO> {

    /**
     * Get all Cargo entities by Company ID.
     *
     * @param companyId the Company ID
     * @return the list of Entities
     */
    List<CargoDTO> findAllByCompanyId(Long companyId);
}
