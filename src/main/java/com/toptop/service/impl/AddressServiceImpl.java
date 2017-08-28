package com.toptop.service.impl;

import com.toptop.domain.Address;
import com.toptop.domain.enums.AddressType;
import com.toptop.repository.AddressRepository;
import com.toptop.service.AddressService;
import com.toptop.service.dto.AddressDTO;
import com.toptop.service.mapper.AddressMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl extends TransactionService<Address, Long, AddressMapper, AddressDTO>
        implements AddressService {

    private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressDTO> findAllByCompanyId(Long id) {
        log.debug("Find all addresses by Company id: {}", id);
        return getMapper().mapToDTOs(addressRepository.findAllByCompanyId(id));
    }

    @Override
    public List<AddressDTO> findAllByCompanyIdAndType(Long id, AddressType type) {
        log.debug("Find all addresses by Company id: {} and type: {}", id, type);
        return getMapper().mapToDTOs(addressRepository.findAllByCompanyIdAndType(id, type));
    }

    @Override
    public List<AddressDTO> findAllByType(AddressType type) {
        log.debug("Find all addresses by address type: {}", type);
        return getMapper().mapToDTOs(addressRepository.findAllByAddressType(type));
    }

    @Override
    public boolean isExist(AddressDTO addressDTO) {
        log.debug("Check if address is exits: {}", addressDTO);
        return getRepository().exists(addressDTO.getId());
}

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected AddressMapper getMapper() {
        return addressMapper;
    }
}
