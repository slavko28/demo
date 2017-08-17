package com.toptop.service.mapper;

import com.toptop.domain.Trailer;
import com.toptop.service.dto.TrailerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface TrailerMapper extends BaseMapper<Trailer, TrailerDTO> {

}
