package com.toptop.service.impl;

import com.toptop.domain.Cargo;
import com.toptop.repository.CargoRepository;
import com.toptop.service.CargoService;
import com.toptop.service.dto.CargoDTO;
import com.toptop.service.mapper.CargoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoServiceImpl extends TransactionService<Cargo, Long, CargoMapper, CargoDTO> implements CargoService {

    private static final Logger log = LoggerFactory.getLogger(CargoServiceImpl.class);

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CargoMapper cargoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CargoDTO> findAllByCompanyId(Long companyId) {
        return getMapper().mapToDTOs(cargoRepository.findAllByCompanyId(companyId));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(CargoDTO cargoDTO) {
        log.debug("Check if cargo is exits: {}", cargoDTO);
        return getRepository().exists(cargoDTO.getId());
    }

    @Override
    protected JpaRepository<Cargo, Long> getRepository() {
        return cargoRepository;
    }

    @Override
    protected CargoMapper getMapper() {
        return cargoMapper;
    }
}
