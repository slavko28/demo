package com.toptop.controller;

import com.toptop.service.OrderDetailService;
import com.toptop.service.dto.OrderDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
public class OrderDetailsFreemarkerController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderDetailsFreemarkerController.class);

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ModelAndView getOrderDetailPage(@PathVariable Long id) {
        LOG.debug("Getting order detail page for order's detail={}", id);
        OrderDetailDTO orderDetailDTO = orderDetailService.findOne(id);
        if (orderDetailDTO == null) {
            throw new NoSuchElementException(String.format("Order detail = %d not found", id));
        }
        ModelAndView view = new ModelAndView("order_detail/detail", "detail", orderDetailDTO);
        view.addObject("order",id);
        return view;
    }
}
