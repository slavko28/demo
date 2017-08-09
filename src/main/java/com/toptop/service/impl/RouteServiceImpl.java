package com.toptop.service.impl;

import com.toptop.domain.Address;
import com.toptop.domain.Route;
import com.toptop.domain.enums.RouteActivityType;
import com.toptop.repository.RouteRepository;
import com.toptop.service.RouteService;
import com.toptop.service.dto.RouteDTO;
import com.toptop.service.mapper.RouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public void save(RouteDTO routeDTO) {
        Route route = routeMapper.map(routeDTO);
        routeRepository.save(route);
    }

    @Override
    public RouteDTO findOne(Long id) {
        return routeMapper.map(routeRepository.findOne(id));
    }

    @Override
    public List<RouteDTO> findAll() {
        return routeMapper.mapToRouteDTOList(routeRepository.findAll());
    }

    @Override
    @Transactional
    public void addRoutePointIntoRoute(Address address, RouteActivityType type, Long routeId) {
        Route route = routeRepository.findOne(routeId);
        if (route != null) {
            throw new IllegalArgumentException("Route doesn't exists");
        }
        if (isRoutePointAlreadyExists(route, address, type)) {
            throw new IllegalArgumentException("Route point already exists");
        }
        Route.RoutePoint routePoint = new Route.RoutePoint();
        routePoint.setAddress(address);
        routePoint.setType(type);
        route.getRoutePoints().add(routePoint);
        routeRepository.save(route);

    }

    private boolean isRoutePointAlreadyExists(Route route, Address address, RouteActivityType type) {
        return route.getRoutePoints().stream().anyMatch(routePoint ->
                routePoint.getAddress().equals(address) && routePoint.getType().equals(type));
    }
}
