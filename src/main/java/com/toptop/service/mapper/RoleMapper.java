package com.toptop.service.mapper;

import com.toptop.domain.Role;
import com.toptop.service.dto.RoleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO map(Role role);

    List<RoleDTO> mapToRoleDTOList(List<Role> roles);

    Role map(RoleDTO roleDTO);

    List<Role> mapToRoleList(List<RoleDTO> roleDTOs);
}