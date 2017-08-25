package com.toptop.service;

import com.toptop.domain.BaseObject;

import java.io.Serializable;
import java.util.List;

public interface AbstractService<T extends BaseObject, ID extends Serializable, DTO extends Object> {

    /**
     * Save new entity.
     *
     * @param dto the entity to save
     * @return the saved entity
     */
    DTO save(DTO dto);

    /**
     * Find entity by Id.
     *
     * @param id the entity id
     * @return the entity
     */
    DTO findOne(ID id);

    /**
     * Find all entities.
     *
     * @return the list of entities
     */
    List<DTO> findAll();

    /**
     * Deletes a given entity.
     *
     * @param id the entity id to delete
     * @throws IllegalArgumentException in case the given entity is {@literal null}.
     */
    void delete(ID id);
}
