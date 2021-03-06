package com.toptop.service.impl;

import com.toptop.domain.Truck;
import com.toptop.repository.TruckRepository;
import com.toptop.service.TruckService;
import com.toptop.service.dto.TruckDTO;
import com.toptop.service.mapper.TruckMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TruckServiceImpl extends TransactionService<Truck, Long, TruckMapper, TruckDTO> implements TruckService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private TruckMapper truckMapper;


    @Override
    @Transactional(readOnly = true)
    public List<TruckDTO> findAllByCompanyId(Long id) {
        LOG.debug("Find all trucks by company id: {}", id);
        return getMapper().mapToDTOs(truckRepository.findAllByCompanyId(id));
    }

    @Override
    protected JpaRepository<Truck, Long> getRepository() {
        return truckRepository;
    }

    @Override
    protected TruckMapper getMapper() {
        return truckMapper;
    }
}
