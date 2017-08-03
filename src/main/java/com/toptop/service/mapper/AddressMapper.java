package com.toptop.service.mapper;

import com.toptop.domain.Address;
import com.toptop.service.dto.AddressDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO map(Address address);

    List<AddressDTO> mapToAddressDTOList(List<Address> addresses);

    Address map(AddressDTO addressDTO);

    List<Address> mapToAddressList(List<AddressDTO> addressDTOS);
}
