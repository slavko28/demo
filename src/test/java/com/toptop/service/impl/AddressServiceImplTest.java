package com.toptop.service.impl;

import com.toptop.domain.Address;
import com.toptop.domain.enums.AddressType;
import com.toptop.repository.AddressRepository;
import com.toptop.service.AddressService;
import com.toptop.service.dto.AddressDTO;
import com.toptop.service.mapper.AddressMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.internal.verification.VerificationModeFactory.atMost;

@SpringBootTest
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

    @Autowired
    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;

    @MockBean
    private AddressMapper addressMapper;

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

        Mockito.when(addressRepository.findAllByAddressType(Mockito.any(AddressType.class)))
                .thenReturn(addressList);
        Mockito.when(addressRepository.findAllByCompanyId(Mockito.anyLong()))
                .thenReturn(addressList);
        Mockito.when(addressRepository.findAllByCompanyIdAndType(Mockito.anyLong(), Mockito.any(AddressType.class)))
                .thenReturn(addressList);

        addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setAddressType(address.getAddressType());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setLocality(address.getLocality());
        addressDTO.setRegion(address.getRegion());

        List<AddressDTO> addressDTOList = new ArrayList<>();
        addressDTOList.add(addressDTO);
        Mockito.when(addressMapper.mapToDTOs(Mockito.anyListOf(Address.class))).thenReturn(addressDTOList);
    }

    @Test
    public void findAllByType() throws Exception {
        List<AddressDTO> allByType = addressService.findAllByType(AddressType.STORAGE);
        Assert.assertTrue(allByType.size() == 1);
        AddressDTO addressDTO = allByType.get(0);
        Assert.assertTrue(this.addressDTO.equals(addressDTO));
        Mockito.verify(addressRepository, atMost(1))
                .findAllByAddressType(Mockito.any(AddressType.class));
    }

    @Test
    public void findAllByCompanyId() throws Exception {
        List<AddressDTO> allByCompanyId = addressService.findAllByCompanyId(1L);
        Assert.assertTrue(allByCompanyId.size() == 1);
        AddressDTO addressDTO = allByCompanyId.get(0);
        Assert.assertTrue(this.addressDTO.equals(addressDTO));
        Mockito.verify(addressRepository, atMost(1))
                .findAllByCompanyId(Mockito.anyLong());
    }

    @Test
    public void findAllByCompanyIdAndType() throws Exception {
        List<AddressDTO> allByCompanyIdAndType = addressService.findAllByCompanyIdAndType(1L, AddressType.STORAGE);
        Assert.assertTrue(allByCompanyIdAndType.size() == 1);
        AddressDTO addressDTO = allByCompanyIdAndType.get(0);
        Assert.assertTrue(this.addressDTO.equals(addressDTO));
        Mockito.verify(addressRepository, atMost(1))
                .findAllByCompanyIdAndType(Mockito.anyLong() ,Mockito.any(AddressType.class));
    }
}
