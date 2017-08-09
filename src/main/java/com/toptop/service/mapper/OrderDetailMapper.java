package com.toptop.service.mapper;

import com.toptop.domain.OrderDetail;
import com.toptop.service.dto.OrderDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, CompanyOrderMapper.class, CompanyEmployeeMapper.class,
        TruckMapper.class, TrailerMapper.class, UserMapper.class})
public interface OrderDetailMapper {


    OrderDetailDTO map(OrderDetail orderDetail);

    List<OrderDetailDTO> mapToOrderDetailDTOList(List<OrderDetail> orderDetail);

    OrderDetail map(OrderDetailDTO orderDetailDTO);

    List<OrderDetail> mapToOrderDetailList(List<OrderDetailDTO> orderDetailDTOS);
}
