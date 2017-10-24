package com.toptop.controller;

import com.toptop.domain.enums.OrderStatus;
import com.toptop.service.CompanyOrderService;
import com.toptop.service.CurrentUserService;
import com.toptop.service.dto.CompanyOrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private CompanyOrderService companyOrderService;

    @Autowired
    private CurrentUserService currentUserService;

    @RequestMapping("/")
    public String getHomePage(){
        return "home";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin")
    public String getHomePageForAdmin() {
        LOG.debug("Getting Admin's home page");
        return "admin/admin-home";
    }

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @RequestMapping("/manager")
    public ModelAndView getHomePageForAManager() {
        LOG.debug("Getting Manager'shome page");
        List<CompanyOrderDTO> orderDTO = companyOrderService.findAllByStatus(OrderStatus.INCOMING);
        ModelAndView modelAndView = new ModelAndView("manager/manager-home", "orders", orderDTO);
        modelAndView.addObject("user", currentUserService.getCurrentUser());
        return modelAndView;
    }
}
