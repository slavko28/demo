package com.toptop.service.mapper;

import com.toptop.domain.Cargo;
import com.toptop.domain.Role;
import com.toptop.service.dto.CargoDTO;
import com.toptop.service.dto.RoleDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    CargoDTO map(Cargo cargo);

    List<RoleDTO> mapToCargoDTOList(List<Cargo> Cargos);

    Cargo map(CargoDTO cargoDTO);

    List<Cargo> mapToCargoList(List<CargoDTO> cargoDTOs);
}