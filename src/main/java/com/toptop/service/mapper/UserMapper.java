package com.toptop.service.mapper;

import com.toptop.domain.User;
import com.toptop.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO map(User user);

    List<UserDTO> mapToUserDTOList(List<User> users);

    @Mapping(target = "password", ignore = true)
    User map(UserDTO userDTO);

    List<User> mapToUserList(List<UserDTO> userDTOS);
}
