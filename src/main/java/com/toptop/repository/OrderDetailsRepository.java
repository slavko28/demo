package com.toptop.repository;

import com.toptop.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long> {
}
