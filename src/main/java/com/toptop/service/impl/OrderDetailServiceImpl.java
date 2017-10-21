package com.toptop.service.impl;

import com.toptop.domain.OrderDetail;
import com.toptop.domain.User;
import com.toptop.repository.OrderDetailsRepository;
import com.toptop.service.CurrentUserService;
import com.toptop.service.OrderDetailService;
import com.toptop.service.dto.OrderDetailDTO;
import com.toptop.service.mapper.OrderDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderDetailServiceImpl extends TransactionService<OrderDetail, Long, OrderDetailMapper, OrderDetailDTO> implements OrderDetailService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private CurrentUserService currentUserService;

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
    @Transactional(readOnly = true)
    public List<OrderDetailDTO> getOrderDetailByCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.debug("Find all order details by current manager: {}", auth.getName());
        return findAllByManagerId(currentUserService.getCurrentUser().get().getId());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDetailDTO findOneById(Long id) {
        log.debug("Find order detail by company order id: {}", id);
        return getMapper().mapToDTO(orderDetailsRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(OrderDetailDTO orderDetailDTO) throws IllegalArgumentException {
        log.debug("Check if order details is exits: {}", orderDetailDTO);
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
