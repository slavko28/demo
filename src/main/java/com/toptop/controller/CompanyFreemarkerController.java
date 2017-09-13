package com.toptop.controller;

import com.toptop.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
}
