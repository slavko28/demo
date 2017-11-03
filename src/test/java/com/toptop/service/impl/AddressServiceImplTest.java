package com.toptop.service.impl;

import com.toptop.domain.Address;
import com.toptop.domain.enums.AddressType;
import com.toptop.repository.AddressRepository;
import com.toptop.service.AddressService;
import com.toptop.service.dto.AddressDTO;
import com.toptop.service.mapper.AddressMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.atMost;

@RunWith(SpringRunner.class)
public class AddressServiceImplTest {

    @TestConfiguration
    static class AddressServiceImplTestContextConfiguration {

        @Bean
        public AddressService addressService() {
            return new AddressServiceImpl();
        }

    }

    private AddressDTO addressDTO;

    @MockBean
    private AddressMapper addressMapper;

    @MockBean
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Before
    public void setUp() {
        Address address = new Address();
        address.setId(2L);
        address.setAddressType(AddressType.STORAGE);
        address.setCountry("Ukraine");
        address.setLocality("Lviv");
        address.setRegion("Lviv");

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);

        when(addressRepository.findAllByAddressType(any(AddressType.class)))
                .thenReturn(addressList);
        when(addressRepository.findAllByCompanyId(anyLong()))
                .thenReturn(addressList);
        when(addressRepository.findAllByCompanyIdAndType(anyLong(), any(AddressType.class)))
                .thenReturn(addressList);

        addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setAddressType(address.getAddressType());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setLocality(address.getLocality());
        addressDTO.setRegion(address.getRegion());

        List<AddressDTO> addressDTOList = new ArrayList<>();
        addressDTOList.add(addressDTO);
        when(addressMapper.mapToDTOs(anyListOf(Address.class))).thenReturn(addressDTOList);
    }

    @Test
    public void shouldFindAllByType() throws Exception {
        List<AddressDTO> allByType = addressService.findAllByType(AddressType.STORAGE);
        assertEquals(1, allByType.size());
        AddressDTO addressDTO = allByType.get(0);
        assertEquals(this.addressDTO, addressDTO);
        verify(addressRepository, atMost(1))
                .findAllByAddressType(any(AddressType.class));
    }

    @Test
    public void shouldFindAllByCompanyId() throws Exception {
        List<AddressDTO> allByCompanyId = addressService.findAllByCompanyId(1L);
        assertEquals(1, allByCompanyId.size());
        AddressDTO addressDTO = allByCompanyId.get(0);
        assertEquals(this.addressDTO, addressDTO);
        verify(addressRepository, atMost(1))
                .findAllByCompanyId(anyLong());
    }

    @Test
    public void shouldFindAllByCompanyIdAndType() throws Exception {
        List<AddressDTO> allByCompanyIdAndType = addressService.findAllByCompanyIdAndType(1L, AddressType.STORAGE);
        assertEquals(1, allByCompanyIdAndType.size());
        AddressDTO addressDTO = allByCompanyIdAndType.get(0);
        assertEquals(this.addressDTO, addressDTO);
        verify(addressRepository, atMost(1))
                .findAllByCompanyIdAndType(anyLong(), any(AddressType.class));
    }

}