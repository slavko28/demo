package com.toptop.service.impl;

import com.toptop.domain.CompanyEmployee;
import com.toptop.domain.enums.EmployeeType;
import com.toptop.repository.CompanyEmployeeRepository;
import com.toptop.service.CompanyEmployeeService;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.dto.CompanyEmployeeDTO;
import com.toptop.service.mapper.CompanyEmployeeMapper;
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
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CompanyEmployeeServiceImplTest {

    @TestConfiguration
    static class CompanyEmployeeServiceImplTestContextConfiguration {
        @Bean
        public CompanyEmployeeService companyEmployeeService() {
            return new CompanyEmployeeServiceImpl();
        }
    }

    private CompanyEmployeeDTO companyEmployeeDTO;

    @MockBean
    private CompanyEmployeeRepository companyEmployeeRepository;

    @Autowired
    private CompanyEmployeeService companyEmployeeService;

    @MockBean
    private CompanyEmployeeMapper employeeMapper;

    @Before
    public void setUp() throws Exception {
        CompanyEmployee companyEmployee = new CompanyEmployee();
        companyEmployee.setId(1L);

        List<CompanyEmployee> listOfEmployee = new ArrayList<>();
        listOfEmployee.add(companyEmployee);

        when(companyEmployeeRepository.findAllByCompanyId(anyLong())).thenReturn(listOfEmployee);
        when(companyEmployeeRepository.findAllByType(any(EmployeeType.class))).thenReturn(listOfEmployee);
        when(companyEmployeeRepository.findAllByCompanyIdAndType(anyLong(), any(EmployeeType.class))).thenReturn(listOfEmployee);

        companyEmployeeDTO = CompanyEmployeeDTO.builder()
                .id(companyEmployee.getId())
                .build();
        List<CompanyEmployeeDTO> listOfEmployeeDTO = new ArrayList<>();
        listOfEmployeeDTO.add(companyEmployeeDTO);

        when(employeeMapper.mapToDTOs(anyListOf(CompanyEmployee.class))).thenReturn(listOfEmployeeDTO);
    }

    @Test
    public void shouldFindAllByCompanyId() throws Exception {
        List<CompanyEmployeeDTO> allByCompanyId = companyEmployeeService.findAllByCompanyId(1L);
        assertEquals(1, allByCompanyId.size());
        CompanyEmployeeDTO employeeDTO = allByCompanyId.get(0);
        assertEquals(this.companyEmployeeDTO, employeeDTO);
        verify(companyEmployeeRepository, atMost(1)).findAllByCompanyId(anyLong());
        verify(employeeMapper, atMost(1)).mapToDTOs(anyListOf(CompanyEmployee.class));
    }

    @Test
    public void shouldFindAllByType() throws Exception {
        List<CompanyEmployeeDTO> allByType = companyEmployeeService.findAllByType(EmployeeType.COMPANY_MANAGER);
        assertEquals(1, allByType.size());
        CompanyEmployeeDTO employeeDTO = allByType.get(0);
        assertEquals(this.companyEmployeeDTO, employeeDTO);
        verify(companyEmployeeRepository, atMost(1)).findAllByType(any(EmployeeType.class));
        verify(employeeMapper, atMost(1)).mapToDTOs(anyListOf(CompanyEmployee.class));
    }

    @Test
    public void shouldFindAllByCompanyIdAndEmployeeType() throws Exception {
        List<CompanyEmployeeDTO> allByCompanyIdAndEmployeeType = companyEmployeeService
                .findAllByCompanyIdAndEmployeeType(1L, EmployeeType.COMPANY_MANAGER);
        assertEquals(1, allByCompanyIdAndEmployeeType.size());
        CompanyEmployeeDTO employeeDTO = allByCompanyIdAndEmployeeType.get(0);
        verify(companyEmployeeRepository, atMost(1)).findAllByCompanyIdAndType(anyLong(), any(EmployeeType.class));
        verify(employeeMapper, atMost(1)).mapToDTOs(anyListOf(CompanyEmployee.class));
    }

}
