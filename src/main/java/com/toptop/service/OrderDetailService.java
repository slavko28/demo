package com.toptop.service;

import com.toptop.domain.OrderDetail;
import com.toptop.service.dto.OrderDetailDTO;

import java.util.List;

/**
 * Service Interface for managing OrderDetail entities.
 */
public interface OrderDetailService extends AbstractService<OrderDetail, Long, OrderDetailDTO> {

    /**
     * Find all orders by Company employee (carrier's driver) id.
     *
     * @return the list af entities
     */
    List<OrderDetailDTO> findAllByDriverId(Long id);
}
