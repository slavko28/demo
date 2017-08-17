package com.toptop.service.impl;

import com.toptop.domain.Address;
import com.toptop.repository.AddressRepository;
import com.toptop.service.AddressService;
import com.toptop.service.dto.AddressDTO;
import com.toptop.service.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class AddressServiceImpl extends TransactionService<Address, Long, AddressMapper, AddressDTO> implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected AddressMapper getMapper() {
        return addressMapper;
    }
}
