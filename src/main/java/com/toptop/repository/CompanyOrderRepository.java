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

    @Query(value = "SELECT * FROM company_order AS c_o LEFT JOIN company_order_order_detail AS c_o_o_d" +
            " ON c_o.id = c_o_o_d.company_order_id LEFT JOIN order_detail AS o_d" +
            " ON c_o_o_d.order_detail_id = o_d.id WHERE o_d.manager_id = :userId", nativeQuery = true) // TODO: change to HQL
    List<CompanyOrder> findAllByUserId(@Param("userId") Long id);
}
