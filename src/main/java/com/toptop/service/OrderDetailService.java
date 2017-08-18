package com.toptop.service;

import com.toptop.domain.OrderDetail;
import com.toptop.service.dto.OrderDetailDTO;

import java.util.List;

/**
 * Service Interface for managing OrderDetail entities.
 */
public interface OrderDetailService extends AbstractService<OrderDetail, Long, OrderDetailDTO> {

    /**
     * Find all entities by Company employee (carrier's driver) id.
     *
     * @return the list af entities
     */
    List<OrderDetailDTO> findAllByDriverId(Long id);

    /**
     * Find all entities by Manager (responsible for the execution) id.
     *
     * @param id the Manager id
     * @return the list af entities
     */
    List<OrderDetailDTO> findAllByManagerId(Long id);
}
