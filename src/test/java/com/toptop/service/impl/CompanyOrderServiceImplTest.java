package com.toptop.service.impl;

import com.toptop.domain.CompanyOrder;
import com.toptop.domain.User;
import com.toptop.domain.enums.LoadingType;
import com.toptop.domain.enums.OrderStatus;
import com.toptop.repository.CompanyOrderRepository;
import com.toptop.service.CompanyOrderService;
import com.toptop.service.CurrentUserService;
import com.toptop.service.dto.CargoDTO;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.dto.CompanyOrderDTO;
import com.toptop.service.mapper.CompanyOrderMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CompanyOrderServiceImplTest {

    @TestConfiguration
    static class CompanyOrderServiceImplTestContextConfiguration {

        @Bean
        public CompanyOrderService companyOrderService() {
            return new CompanyOrderServiceImpl();
        }
    }

    private CompanyOrderDTO companyOrderDTO;

    @MockBean
    private CompanyOrderRepository companyOrderRepository;

    @MockBean
    private CompanyOrderMapper companyOrderMapper;

    @MockBean
    private CurrentUserService currentUserService;

    @Autowired
    private CompanyOrderService companyOrderService;

    @Before
    public void setUp() throws Exception {
        CompanyOrder order = new CompanyOrder();
        order.setId(1L);
        order.setOrderDate(LocalDateTime.now());
        order.setLoadingType(LoadingType.BACK_LOADING);
        order.setStatus(OrderStatus.INCOMING);

        List<CompanyOrder> orderList = new ArrayList<>();
        orderList.add(order);

        when(companyOrderRepository.findAllByManagerId(anyLong())).thenReturn(orderList);
        when(companyOrderRepository.findAllByCompanyId(anyLong())).thenReturn(orderList);
        when(companyOrderRepository.findAllByStatus(any(OrderStatus.class))).thenReturn(orderList);
        when(companyOrderRepository.findAllByUserId(anyLong())).thenReturn(orderList);

        companyOrderDTO = CompanyOrderDTO.builder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .loadingType(order.getLoadingType())
                .company(new CompanyDTO())
                .cargo(new CargoDTO())
                .status(order.getStatus())
                .build();
        List<CompanyOrderDTO> orderDTOList = new ArrayList<>();
        orderDTOList.add(companyOrderDTO);
        when(companyOrderMapper.mapToDTOs(anyListOf(CompanyOrder.class))).thenReturn(orderDTOList);

        User user = new User();
        user.setId(1L);
        when(currentUserService.getCurrentUser()).thenReturn(Optional.of(user));
    }

    @Test
    public void shouldFindAllByCompanyEmployeeId() throws Exception {
        List<CompanyOrderDTO> allByCompanyEmployeeId = companyOrderService.findAllByCompanyEmployeeId(1L);
        assertEquals(1, allByCompanyEmployeeId.size());
        CompanyOrderDTO orderDTO = allByCompanyEmployeeId.get(0);
        assertEquals(this.companyOrderDTO, orderDTO);
        verify(companyOrderRepository, atMost(1)).findAllByManagerId(anyLong());
    }

    @Test
    public void shouldFindAllByCompanyId() throws Exception {
        List<CompanyOrderDTO> allByCompanyId = companyOrderService.findAllByCompanyId(1L);
        assertEquals(1, allByCompanyId.size());
        CompanyOrderDTO orderDTO = allByCompanyId.get(0);
        assertEquals(this.companyOrderDTO, orderDTO);
        verify(companyOrderRepository, atMost(1)).findAllByCompanyId(anyLong());
    }

    @Test
    public void shouldFindAllByStatus() throws Exception {
        List<CompanyOrderDTO> allByStatus = companyOrderService.findAllByStatus(OrderStatus.INCOMING);
        assertEquals(1,allByStatus.size());
        CompanyOrderDTO orderDTO = allByStatus.get(0);
        assertEquals(this.companyOrderDTO, orderDTO);
        verify(companyOrderRepository, atMost(1)).findAllByStatus(any(OrderStatus.class));
    }

    @Test
    @WithMockUser(username = "user@mail")
    public void shouldFindAllByCurrentUser() throws Exception {
        List<CompanyOrderDTO> allByCurrentUser = companyOrderService.findAllByCurrentUser();
        assertEquals(1, allByCurrentUser.size());
        CompanyOrderDTO orderDTO = allByCurrentUser.get(0);
        assertEquals(this.companyOrderDTO, orderDTO);
        verify(companyOrderRepository, atMost(1)).findAllByUserId(anyLong());
        verify(currentUserService, atMost(1)).getCurrentUser();

    }
}
