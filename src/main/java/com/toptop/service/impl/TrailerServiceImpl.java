package com.toptop.service.impl;

import com.toptop.domain.Trailer;
import com.toptop.domain.enums.TrailerType;
import com.toptop.repository.TrailerRepository;
import com.toptop.service.TrailerService;
import com.toptop.service.dto.TrailerDTO;
import com.toptop.service.mapper.TrailerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrailerServiceImpl extends TransactionService<Trailer, Long, TrailerMapper, TrailerDTO> implements TrailerService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private TrailerRepository trailerRepository;

    @Autowired
    private TrailerMapper trailerMapper;


    @Override
    @Transactional(readOnly = true)
    public List<TrailerDTO> findAllByType(TrailerType trailerType) {
        log.debug("Find all trailers by type: {}", trailerType);
        return getMapper().mapToDTOs(trailerRepository.findAllByType(trailerType));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TrailerDTO> findAllByCompanyId(Long id) {
        log.debug("Find all trailers by company id: {}", id);
        return getMapper().mapToDTOs(trailerRepository.findAllByCompanyId(id));
    }

    @Override
    protected JpaRepository<Trailer, Long> getRepository() {
        return trailerRepository;
    }

    @Override
    protected TrailerMapper getMapper() {
        return trailerMapper;
    }
}
