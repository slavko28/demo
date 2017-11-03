package com.toptop.service.impl;

import com.toptop.domain.Cargo;
import com.toptop.domain.Company;
import com.toptop.repository.CargoRepository;
import com.toptop.service.CargoService;
import com.toptop.service.dto.CargoDTO;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.mapper.CargoMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CargoServiceImplTest {

    @TestConfiguration
    static class CargoServiceImplTestContextConfiguration {

        @Bean
        public CargoService cargoService() {
            return new CargoServiceImpl();
        }

    }
    private CargoDTO cargoDTO;

    @MockBean
    private CargoRepository cargoRepository;

    @MockBean
    private CargoMapper cargoMapper;

    @Autowired
    private CargoService cargoService;

    @Before
    public void setUp() throws Exception {
        Company company = new Company();
        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setCompany(company);
        cargo.setVolume(86);
        cargo.setWeight(22.0);
        cargo.setDescription("Cargo description");

        List<Cargo> cargoList = new ArrayList<>();
        cargoList.add(cargo);

        when(cargoRepository.findAllByCompanyId(anyLong())).thenReturn(cargoList);

        cargoDTO = CargoDTO.builder()
                .id(cargo.getId())
                .company(new CompanyDTO())
                .volume(cargo.getVolume())
                .weight(cargo.getWeight())
                .description(cargo.getDescription())
                .build();
        List<CargoDTO> cargoDTOList = new ArrayList<>();
        cargoDTOList.add(cargoDTO);

        when(cargoMapper.mapToDTOs(anyListOf(Cargo.class))).thenReturn(cargoDTOList);
    }

    @Test
    public void shouldFindAllByCompanyId() throws Exception {
        List<CargoDTO> allByCompanyId = cargoService.findAllByCompanyId(1L);
        assertEquals(1, allByCompanyId.size());
        CargoDTO cargoDTO = allByCompanyId.get(0);
        assertEquals(this.cargoDTO, cargoDTO);
        verify(cargoRepository, atMost(1))
                .findAllByCompanyId(anyLong());
    }

}