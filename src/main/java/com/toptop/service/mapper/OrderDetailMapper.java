package com.toptop.service.mapper;

import com.toptop.domain.OrderDetail;
import com.toptop.service.dto.OrderDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, CompanyOrderMapper.class, CompanyEmployeeMapper.class,
        TruckMapper.class, TrailerMapper.class, UserMapper.class})
public interface OrderDetailMapper {

    @Mapping(source = "companyOrder.id", target = "orderId")
    @Mapping(source = "carrier.id", target = "carrierId")
    @Mapping(source = "truck.id", target = "truckId")
    @Mapping(source = "truck.licensePlate", target = "truckLicensePlate")
    @Mapping(source = "trailer.id", target = "trailerId")
    @Mapping(source = "trailer.licensePlate", target = "trailerLicensePlate")
    @Mapping(source = "driver.id", target = "driverId")
    @Mapping(source = "driver.firstName", target = "driverFirstName")
    @Mapping(source = "driver.lastName", target = "driverLastName")
    @Mapping(source = "manager.id", target = "managerId")
    @Mapping(source = "manager.name", target = "managerFirstName")
    @Mapping(source = "manager.lastName", target = "managerLastName")
    OrderDetailDTO map(OrderDetail orderDetail);

    List<OrderDetailDTO> mapToOrderDetailDTOList(List<OrderDetail> orderDetail);

    @Mapping(source = "orderId", target = "companyOrder.id")
    @Mapping(source = "carrierId", target = "carrier.id")
    @Mapping(source = "truckId", target = "truck.id")
    @Mapping(source = "trailerId", target = "trailer.id")
    @Mapping(source = "driverId", target = "driver.id")
    @Mapping(source = "managerId", target = "manager.id")
    OrderDetail map(OrderDetailDTO orderDetailDTO);

    List<OrderDetail> mapToOrderDetailList(List<OrderDetailDTO> orderDetailDTOS);
}
