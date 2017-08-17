package com.toptop.service.mapper;

import com.toptop.domain.BaseObject;

import java.util.List;

/**
 * Marker interface
 */
public interface BaseMapper <Entity extends BaseObject, DTO extends Object>{

    DTO mapToDTO(Entity entity);

    List<DTO> mapToDTOs(List<Entity> entities);

    Entity map(DTO dto);

    List<Entity> map(List<DTO> dtos);
}
