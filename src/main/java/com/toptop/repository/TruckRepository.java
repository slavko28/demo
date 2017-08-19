package com.toptop.repository;

import com.toptop.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckRepository extends JpaRepository<Truck, Long>{

    List<Truck> findAllByCompanyId(Long id);
}
