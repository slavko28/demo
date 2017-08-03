package com.toptop.service;

import com.toptop.domain.enums.OrderStatus;
import com.toptop.service.dto.CompanyOrderDTO;

import java.util.List;

/**
 * Service Interface for managing Company's order entities.
 */
public interface CompanyOrderService {

    /**
     * Save new entity.
     *
     * @param orderDTO the entity to save
     * @return the saved entity
     */
    CompanyOrderDTO save(CompanyOrderDTO orderDTO);

    /**
     * Find Company's order by Id.
     *
     * @param id the Company's order Id
     * @return the entity
     */
    CompanyOrderDTO findOne(Long id);

    /**
     * Find all orders by Company employee (responsible manager) id.
     *
     * @param id the Company employee id
     * @return the list af entities
     */
    List<CompanyOrderDTO> findAllByCompanyEmployeeId(Long id);

    /**
     * Find all orders by Order status.
     *
     * @param orderStatus order status
     * @return the list af entities
     */
    List<CompanyOrderDTO> findAllByStatus(OrderStatus orderStatus);


}
