package com.toptop.service.impl;

import com.toptop.domain.OrderDetail;
import com.toptop.repository.OrderDetailsRepository;
import com.toptop.service.OrderDetailService;
import com.toptop.service.dto.OrderDetailDTO;
import com.toptop.service.mapper.OrderDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl extends TransactionService<OrderDetail, Long, OrderDetailMapper, OrderDetailDTO> implements OrderDetailService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDetailDTO> findAllByDriverId(Long id) {
        log.debug("Find all order details by driver id: {}", id);
        return getMapper().mapToDTOs(orderDetailsRepository.findAllByDriverId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDetailDTO> findAllByManagerId(Long id) {
        log.debug("Find all order details by manager id: {}", id);
        return getMapper().mapToDTOs(orderDetailsRepository.findAllByManagerId(id));
    }

    @Override
    public boolean isExist(OrderDetailDTO orderDetailDTO) {
        return getRepository().exists(orderDetailDTO.getId());
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
