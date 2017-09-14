package com.toptop.controller;

import com.toptop.service.CompanyService;
import com.toptop.service.dto.CompanyDTO;
import com.toptop.service.dto.CompanyEmployeeDTO;
import com.toptop.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
public class CompanyFreemarkerController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyFreemarkerController.class);

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company/all", method = RequestMethod.GET)
    public ModelAndView getAllCompanies(){
        LOG.debug("Request to get all companies");
        return new ModelAndView("company/company-list", "companies", companyService.findAll());
    }

    @RequestMapping(value = "/company/{id}",method = RequestMethod.GET)
    public ModelAndView getCompanyPage(@PathVariable Long id) {
        LOG.debug("Getting company page for company={}", id);
        CompanyDTO companyDTO = companyService.findOne(id);
        if (companyDTO == null) {
            throw new NoSuchElementException(String.format("Company = %d not found", id));
        }
        return new ModelAndView("company/company", "company", companyDTO);
    }
}
