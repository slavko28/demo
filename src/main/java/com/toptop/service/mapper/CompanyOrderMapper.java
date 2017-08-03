package com.toptop.service.mapper;

import com.toptop.domain.CompanyOrder;
import com.toptop.service.dto.CompanyOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyOrderMapper {

    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "manager.id", target = "managerId")
    @Mapping(source = "manager.firstName", target = "managerFirstName")
    @Mapping(source = "manager.lastName", target = "managerLastName")
    @Mapping(source = "manager.phoneNumber", target = "phoneNumber")
    @Mapping(source = "orderDetail.id", target = "orderDetailsId")
    CompanyOrderDTO map(CompanyOrder order);

    List<CompanyOrderDTO> mapToDTOList(List<CompanyOrder> orders);

    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "managerId", target = "manager.id")
//    @Mapping(target = "managerFirstName", ignore = true)
//    @Mapping(target = "managerLastName", ignore = true)
//    @Mapping(target = "phoneNumber", ignore = true)
    @Mapping(source = "orderDetailsId", target = "orderDetail.id")
    CompanyOrder map(CompanyOrderDTO orderDTO);

    List<CompanyOrder> mapToList(List<CompanyOrderDTO> orderDTOS);
}
