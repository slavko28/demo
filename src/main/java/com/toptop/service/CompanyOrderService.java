package com.toptop.service;

import com.toptop.domain.CompanyOrder;
import com.toptop.domain.enums.OrderStatus;
import com.toptop.service.dto.CompanyOrderDTO;

import java.util.List;

/**
 * Service Interface for managing Company's order entities.
 */
public interface CompanyOrderService extends AbstractService<CompanyOrder, Long, CompanyOrderDTO> {

    /**
     * Find all orders by Company employee (responsible manager) id.
     *
     * @param id the Company employee id
     * @return the list af entities
     */
    List<CompanyOrderDTO> findAllByCompanyEmployeeId(Long id);

    /**
     * Find all orders by Company (customer) id.
     *
     * @param id the Company id
     * @return the list af entities
     */
    List<CompanyOrderDTO> findAllByCompanyId(Long id);

    /**
     * Find all orders by Order status.
     *
     * @param orderStatus order status
     * @return the list af entities
     */
    List<CompanyOrderDTO> findAllByStatus(OrderStatus orderStatus);

    /**
     * Find all orders by current User.
     *
     * @return the list of entities
     */
    List<CompanyOrderDTO> findAllByCurrentUser();
}
