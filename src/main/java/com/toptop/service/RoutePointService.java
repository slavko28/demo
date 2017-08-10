package com.toptop.service;

import com.toptop.service.dto.RoutePointDTO;

import java.util.List;

/**
 * Service Interface for managing Route entities.
 */
public interface RoutePointService {

    /**
     * Save new entity.
     *
     * @param routePointDTO Route point to save
     */
    void save(RoutePointDTO routePointDTO);

    /**
     * Find Route point by Id.
     *
     * @param id  Route point id
     * @return the entity
     */
    RoutePointDTO findOne(Long id);

    /**
     * Find all Route points.
     *
     * @return the list of entities
     */
    List<RoutePointDTO> findAll();
}
