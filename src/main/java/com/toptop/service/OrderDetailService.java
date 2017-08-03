package com.toptop.service;

import com.toptop.service.dto.CompanyOrderDTO;
import com.toptop.service.dto.OrderDetailDTO;

import java.util.List;

/**
 * Service Interface for managing OrderDetail entities.
 */
public interface OrderDetailService {

    /**
     * Save new entity.
     *
     * @param orderDetailDTO the entity to save
     * @return the saved entity
     */
    OrderDetailDTO save(OrderDetailDTO orderDetailDTO);

    /**
     * Find Order detail by Id.
     *
     * @param id the Order detail Id
     * @return the entity
     */
    OrderDetailDTO findOne(Long id);

    /**
     * Find all Order detail.
     *
     * @return the list af entities
     */
    List<OrderDetailDTO> findAll();

    /**
     * Find all orders by Company employee (carrier's driver) id.
     *
     * @return the list af entities
     */
    List<OrderDetailDTO> findAllByDriverId(Long id);
}
