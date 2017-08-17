package com.toptop.service.mapper;

import com.toptop.domain.Address;
import com.toptop.service.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {

}
