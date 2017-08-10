package com.toptop.service.mapper;

import com.toptop.domain.Cargo;
import com.toptop.service.dto.CargoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CargoMapper {

    CargoDTO map(Cargo cargo);

    List<CargoDTO> mapToCargoDTOList(List<Cargo> cargo);

    Cargo map(CargoDTO cargoDTO);

    List<Cargo> mapToCargoList(List<CargoDTO> cargoDTOs);
}