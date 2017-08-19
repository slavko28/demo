package com.toptop.repository;

import com.toptop.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findAllByDriverId(Long id);

    List<OrderDetail> findAllByManagerId(Long id);

}
