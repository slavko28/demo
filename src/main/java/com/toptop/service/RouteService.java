package com.toptop.service;

import com.toptop.domain.Address;
import com.toptop.domain.enums.RouteActivityType;
import com.toptop.service.dto.RouteDTO;

import java.util.List;

/**
 * Service Interface for managing Route entities.
 */
public interface RouteService {

    /**
     * Save new entity.
     *
     * @param RouteDTO the Route to save
     */
    void save(RouteDTO RouteDTO);

    /**
     * Find Route by Id.
     *
     * @param id the Route id
     * @return the entity
     */
    RouteDTO findOne(Long id);

    /**
     * Find all Routes.
     *
     * @return the list of entities
     */
    List<RouteDTO> findAll();

    /**
     * Add new Route point to Route.
     *
     * @param address Address of new route point
     * @param type    type of new route point
     */
    void addRoutePointIntoRoute(Address address, RouteActivityType type, Long routeId);
}
