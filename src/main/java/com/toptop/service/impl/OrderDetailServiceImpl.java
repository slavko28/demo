package com.toptop.service.impl;

import com.toptop.domain.OrderDetail;
import com.toptop.repository.OrderDetailsRepository;
import com.toptop.service.OrderDetailService;
import com.toptop.service.dto.OrderDetailDTO;
import com.toptop.service.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl extends TransactionService<OrderDetail, Long, OrderDetailMapper, OrderDetailDTO> implements OrderDetailService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDetailDTO> findAllByDriverId(Long id) {
        return getMapper().mapToDTOs(orderDetailsRepository.findAllByDriverId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDetailDTO> findAllByManagerId(Long id) {
        return getMapper().mapToDTOs(orderDetailsRepository.findAllByManagerId(id));
    }

    @Override
    protected JpaRepository<OrderDetail, Long> getRepository() {
        return orderDetailsRepository;
    }

    @Override
    protected OrderDetailMapper getMapper() {
        return orderDetailMapper;
    }
}
