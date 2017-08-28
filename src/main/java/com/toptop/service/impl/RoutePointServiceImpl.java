package com.toptop.service.impl;

import com.toptop.domain.RoutePoint;
import com.toptop.repository.RoutePointRepository;
import com.toptop.service.RoutePointService;
import com.toptop.service.dto.RoutePointDTO;
import com.toptop.service.mapper.RoutePointMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoutePointServiceImpl extends TransactionService<RoutePoint, Long, RoutePointMapper, RoutePointDTO> implements RoutePointService {

    private static final Logger log = LoggerFactory.getLogger(RoutePointServiceImpl.class);

    @Autowired
    private RoutePointRepository routePointRepository;

    @Autowired
    private RoutePointMapper routePointMapper;

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(RoutePointDTO routePointDTO) throws IllegalArgumentException {
        log.debug("Check if route point is exits: {}", routePointDTO);
        return getRepository().exists(routePointDTO.getId());
    }

    @Override
    protected JpaRepository<RoutePoint, Long> getRepository() {
        return routePointRepository;
    }

    @Override
    protected RoutePointMapper getMapper() {
        return routePointMapper;
    }
}
