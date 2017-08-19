package com.toptop.repository;

import com.toptop.domain.CompanyOrder;
import com.toptop.domain.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyOrderRepository extends JpaRepository<CompanyOrder, Long>{

    List<CompanyOrder> findAllByManagerId(Long id);

    List<CompanyOrder> findAllByCompanyId(Long id);

    List<CompanyOrder> findAllByStatus(OrderStatus orderStatus);
}
