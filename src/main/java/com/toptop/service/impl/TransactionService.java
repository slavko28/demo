package com.toptop.service.impl;

import com.toptop.domain.BaseObject;
import com.toptop.service.AbstractService;
import com.toptop.service.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class TransactionService<T extends BaseObject, ID extends Serializable,
        M extends BaseMapper<T, DTO>, DTO extends Object> implements AbstractService<T, ID, DTO> {

    @Override
    public DTO save(DTO dto) {
        T entity = getMapper().map(dto);
        return getMapper().mapToDTO(getRepository().save(entity));
    }

    @Override
    @Transactional(readOnly = true)
    public DTO findOne(ID id) {
        return getMapper().mapToDTO(getRepository().findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> findAll() {
        return getMapper().mapToDTOs(getRepository().findAll());
    }

    @Override
    public void delete(ID id) {
        T entity = getRepository().findOne(id);
        if (entity == null) {
            throw new IllegalArgumentException("Entity does not exists, ID: " + id);
        }
        entity.setEnabled(false);
        getRepository().save(entity);
    }

    protected abstract JpaRepository<T, ID> getRepository();

    protected abstract M getMapper();
}
