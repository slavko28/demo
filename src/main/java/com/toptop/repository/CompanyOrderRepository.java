package com.toptop.repository;

import com.toptop.domain.CompanyOrder;
import com.toptop.domain.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyOrderRepository extends JpaRepository<CompanyOrder, Long>{

    List<CompanyOrder> findAllByManagerId(Long id);

    List<CompanyOrder> findAllByCompanyId(Long id);

    List<CompanyOrder> findAllByStatus(OrderStatus orderStatus);

    @Query("select orders from CompanyOrder orders left join orders.orderDetail details where orders.enabled = true " +
            "and details.manager.id = :userId")
    List<CompanyOrder> findAllByUserId(@Param("userId") Long id);
}
