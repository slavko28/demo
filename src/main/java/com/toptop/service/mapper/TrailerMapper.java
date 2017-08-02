package com.toptop.service.mapper;

import com.toptop.domain.Trailer;
import com.toptop.service.dto.TrailerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CompanyMapper.class)
public interface TrailerMapper {

    @Mapping(source = "company.id", target = "companyId")
    TrailerDTO map(Trailer trailer);

    List<TrailerDTO> mapToTrailerDTOList(List<Trailer> trailers);

    @Mapping(source = "companyId", target = "company.id")
    Trailer map(TrailerDTO trailerDTO);

    List<Trailer> mapToTrailerList(List<TrailerDTO> trailerDTOs);
}
