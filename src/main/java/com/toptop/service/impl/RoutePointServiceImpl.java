package com.toptop.service.impl;

import com.toptop.domain.RoutePoint;
import com.toptop.repository.RoutePointRepository;
import com.toptop.service.RoutePointService;
import com.toptop.service.dto.RoutePointDTO;
import com.toptop.service.mapper.RoutePointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoutePointServiceImpl extends TransactionService<RoutePoint, Long, RoutePointMapper, RoutePointDTO> implements RoutePointService {

    @Autowired
    private RoutePointRepository routePointRepository;

    @Autowired
    private RoutePointMapper routePointMapper;

    @Override
    public boolean isExist(RoutePointDTO routePointDTO) {
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
