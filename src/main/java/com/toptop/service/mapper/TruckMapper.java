package com.toptop.service.mapper;

import com.toptop.domain.Truck;
import com.toptop.service.dto.TruckDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface TruckMapper {

    TruckDTO map(Truck truck);

    List<TruckDTO> mapToTruckDTOList(List<Truck> trucks);

    Truck map(TruckDTO truckDTO);

    List<Truck> mapToTruckList(List<TruckDTO> truckDTOs);
}
