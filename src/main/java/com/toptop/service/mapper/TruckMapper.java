package com.toptop.service.mapper;

import com.toptop.domain.Truck;
import com.toptop.service.dto.TruckDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface TruckMapper {

    @Mapping(source = "company.id", target = "companyId")
    TruckDTO map(Truck truck);

    List<TruckDTO> mapToTruckDTOList(List<Truck> trucks);

    @Mapping(source = "companyId", target = "company.id")
    Truck map(TruckDTO truckDTO);

    List<Truck> mapToTruckList(List<TruckDTO> truckDTOs);
}
