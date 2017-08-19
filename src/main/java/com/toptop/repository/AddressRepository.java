package com.toptop.repository;

import com.toptop.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select address from Company as company join company.address as address " +
            "where company.id = :id and address.enabled = true")
    List<Address> findAllByCompanyId(@Param("id") Long id);
}
