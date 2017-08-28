package com.toptop.service.impl;

import com.toptop.domain.Route;
import com.toptop.repository.RouteRepository;
import com.toptop.service.RouteService;
import com.toptop.service.dto.RouteDTO;
import com.toptop.service.mapper.RouteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RouteServiceImpl extends TransactionService<Route, Long, RouteMapper, RouteDTO> implements RouteService {

    private static final Logger log = LoggerFactory.getLogger(RouteServiceImpl.class);

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteMapper routeMapper;

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(RouteDTO routeDTO) throws IllegalArgumentException {
        log.debug("Check if address is exits: {}", routeDTO);
        return getRepository().exists(routeDTO.getId());
    }

    @Override
    protected JpaRepository<Route, Long> getRepository() {
        return routeRepository;
    }

    @Override
    protected RouteMapper getMapper() {
        return routeMapper;
    }
}
