package com.toptop.service.impl;

import com.toptop.domain.CompanyOrder;
import com.toptop.domain.enums.OrderStatus;
import com.toptop.repository.CompanyOrderRepository;
import com.toptop.service.CompanyOrderService;
import com.toptop.service.dto.CompanyOrderDTO;
import com.toptop.service.mapper.CompanyOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyOrderServiceImpl extends TransactionService<CompanyOrder, Long, CompanyOrderMapper, CompanyOrderDTO> implements CompanyOrderService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CompanyOrderRepository orderRepository;

    @Autowired
    private CompanyOrderMapper orderMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompanyOrderDTO> findAllByCompanyEmployeeId(Long id) {
        log.debug("Find all orders by company id: {}", id);
        return getMapper().mapToDTOs(orderRepository.findAllByManagerId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyOrderDTO> findAllByCompanyId(Long id) {
        log.debug("Find all orders by company id: {}", id);
        return getMapper().mapToDTOs(orderRepository.findAllByCompanyId(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompanyOrderDTO> findAllByStatus(OrderStatus orderStatus) {
        log.debug("Find all orders by status: {}", orderStatus);
        return getMapper().mapToDTOs(orderRepository.findAllByStatus(orderStatus));
    }

    @Override
    protected JpaRepository<CompanyOrder, Long> getRepository() {
        return orderRepository;
    }

    @Override
    protected CompanyOrderMapper getMapper() {
        return orderMapper;
    }
}
