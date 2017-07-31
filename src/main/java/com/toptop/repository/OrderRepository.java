package com.toptop.repository;

import com.toptop.domain.CompanyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CompanyOrder, Long>{
}
