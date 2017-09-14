package com.toptop.repository;

import com.toptop.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long> {

    List<OrderDetail> findAllByDriverId(Long id);

    List<OrderDetail> findAllByManagerId(Long id);

}
