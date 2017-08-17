package com.toptop.service.mapper;

import com.toptop.domain.OrderDetail;
import com.toptop.service.dto.OrderDetailDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, CompanyOrderMapper.class, CompanyEmployeeMapper.class,
        TruckMapper.class, TrailerMapper.class, UserMapper.class})
public interface OrderDetailMapper extends BaseMapper<OrderDetail, OrderDetailDTO> {

}
