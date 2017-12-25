package com.toptop.service.impl;

import com.toptop.domain.OrderDetail;
import com.toptop.repository.OrderDetailsRepository;
import com.toptop.service.CurrentUserService;
import com.toptop.service.OrderDetailService;
import com.toptop.service.dto.OrderDetailDTO;
import com.toptop.service.mapper.OrderDetailMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class OrderDetailServiceImplTest {

    @TestConfiguration
    public static class OrderDetailServiceImplTestContextConfiguration {

        @Bean
        public OrderDetailService orderDetailService() {
            return new OrderDetailServiceImpl();
        }
    }

    private OrderDetailDTO orderDetailDTO;

    @MockBean
    private OrderDetailsRepository repository;

    @MockBean
    private OrderDetailMapper mapper;

    @MockBean
    private CurrentUserService currentUserService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Before
    public void setUp() {
        OrderDetail orderDetail = new OrderDetail();
        List<OrderDetail> list = new ArrayList<>();
        list.add(orderDetail);
        when(repository.findAllByDriverId(anyLong())).thenReturn(list);
        when(repository.findAllByManagerId(anyLong())).thenReturn(list);
        orderDetailDTO = new OrderDetailDTO();
        List<OrderDetailDTO> dtoList = new ArrayList<>();
        dtoList.add(orderDetailDTO);
        when(mapper.mapToDTOs(anyListOf(OrderDetail.class))).thenReturn(dtoList);

    }

    @Test
    public void shouldFindAllByDriverId() throws Exception {
        List<OrderDetailDTO> allByDriverId = orderDetailService.findAllByDriverId(1L);
        assertTrue(allByDriverId.size() > 0);
        OrderDetailDTO dto = allByDriverId.get(0);
        assertNotNull(dto);
        assertEquals(orderDetailDTO, dto);
        verify(repository, atMost(1)).findAllByDriverId(anyLong());
        verify(mapper, atMost(1)).mapToDTOs(anyListOf(OrderDetail.class));
        verify(currentUserService, never()).getCurrentUser();
    }

    @Test
    public void shouldFindAllByManagerId() throws Exception {

    }

    @Test
    public void getOrderDetailByCurrentUser() throws Exception {
    }

}
