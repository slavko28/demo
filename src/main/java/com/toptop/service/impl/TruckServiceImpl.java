package com.toptop.service.impl;

import com.toptop.domain.Truck;
import com.toptop.repository.TruckRepository;
import com.toptop.service.TruckService;
import com.toptop.service.dto.TruckDTO;
import com.toptop.service.mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TruckServiceImpl extends TransactionService<Truck, Long, TruckMapper, TruckDTO> implements TruckService {

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private TruckMapper truckMapper;


    @Override
    @Transactional(readOnly = true)
    public List<TruckDTO> findAllByCompanyId(Long id) {
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
