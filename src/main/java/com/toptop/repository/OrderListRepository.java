package com.toptop.repository;

import com.toptop.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
}
