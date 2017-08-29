package com.toptop.repository;

import com.toptop.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findAllByCompanyId(Long companyId);
}
