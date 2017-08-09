package com.toptop.service.mapper;

import com.toptop.domain.CompanyOrder;
import com.toptop.service.dto.CompanyOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RouteMapper.class, CargoMapper.class, CompanyMapper.class, CompanyEmployeeMapper.class})
public interface CompanyOrderMapper {

    CompanyOrderDTO map(CompanyOrder order);

    List<CompanyOrderDTO> mapToDTOList(List<CompanyOrder> orders);

    CompanyOrder map(CompanyOrderDTO orderDTO);

    List<CompanyOrder> mapToList(List<CompanyOrderDTO> orderDTOS);
}
