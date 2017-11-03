package com.toptop.controller;

import com.toptop.service.CompanyService;
import com.toptop.service.RouteService;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.dto.CompanyOrderDTO;
import com.toptop.service.dto.RouteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CompanyOrderFreemarkerController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyOrderFreemarkerController.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RouteService routeService;


    @PreAuthorize("hasAuthority('MANAGER')")
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ModelAndView getNewOrderPage(){
        LOG.debug("Getting a page to create an order");
        List<CompanyDTO> companyDTOs = companyService.findAll();
        List<RouteDTO> routeDTOs = routeService.findAll();
        ModelAndView modelAndView = new ModelAndView("order/order-create", "order", new CompanyOrderDTO());
        modelAndView.addObject("companies", companyDTOs);
        modelAndView.addObject("routs", routeDTOs);
        return modelAndView;

    }
}
