package com.toptop.repository;

import com.toptop.domain.Address;
import com.toptop.domain.enums.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select address from Company as company join company.address as address " +
            "where company.id = :id and address.enabled = true")
    List<Address> findAllByCompanyId(@Param("id") Long id);

    @Query("select address from Company as company join company.address as address " +
            "where company.id = :id and address.addressType = :addressType and address.enabled = true")
    List<Address> findAllByCompanyIdAndType(@Param("id") Long id, @Param("addressType") AddressType addressType);

    List<Address> findAllByAddressType(AddressType type);
}
