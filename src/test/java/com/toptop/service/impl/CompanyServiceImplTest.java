package com.toptop.service.impl;

import com.toptop.domain.Company;
import com.toptop.repository.CompanyRepository;
import com.toptop.service.CompanyService;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.mapper.CompanyMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CompanyServiceImplTest {

    @TestConfiguration
    static class CompanyServiceImplTestContextConfiguration {

        @Bean
        public CompanyService companyService() {
            return new CompanyServiceImpl();
        }
    }

    private CompanyDTO companyDTO;

    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyService companyService;

    @Before
    public void setUp() throws Exception {
        when(companyRepository.findOneByCompanyCod(anyLong())).thenReturn(new Company());
        companyDTO = new CompanyDTO();
        companyDTO.setId(1L);
        when(companyMapper.mapToDTO(any(Company.class))).thenReturn(companyDTO);
    }

    @Test
    public void findByOneByCompanyCod() throws Exception {
        Optional<CompanyDTO> oneByCompanyCod = companyService.findOneByCompanyCod(111111111L);
        assertTrue(oneByCompanyCod.isPresent());
        assertEquals(this.companyDTO, oneByCompanyCod.get());
        verify(companyRepository, atMost(1)).findOneByCompanyCod(anyLong());
        verify(companyMapper, atMost(1)).mapToDTO(any(Company.class));
    }

}