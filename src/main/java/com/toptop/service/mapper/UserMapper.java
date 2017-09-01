package com.toptop.service.mapper;

import com.toptop.domain.User;
import com.toptop.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {

    @Override
    @Mapping(target = "password", ignore = true)
    UserDTO mapToDTO(User user);
}
