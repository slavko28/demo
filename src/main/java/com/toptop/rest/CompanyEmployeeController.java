package com.toptop.rest;

import com.toptop.domain.enums.EmployeeType;
import com.toptop.service.CompanyEmployeeService;
import com.toptop.service.dto.CompanyEmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class CompanyEmployeeController {

    private final Logger log = LoggerFactory.getLogger(CompanyEmployeeController.class);

    @Autowired
    private CompanyEmployeeService companyEmployeeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CompanyEmployeeDTO> create(@Validated @PathVariable CompanyEmployeeDTO employeeDTO) {
        log.debug("request to create mew company employee: {}", employeeDTO);
        if (employeeDTO.getId() != null) {
            return ResponseEntity.ok(companyEmployeeService.save(employeeDTO));
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<CompanyEmployeeDTO> update(@Validated @PathVariable CompanyEmployeeDTO employeeDTO) {
        log.debug("request to update company employee {}", employeeDTO);
        if (companyEmployeeService.isExist(employeeDTO)) {
            return ResponseEntity.ok(companyEmployeeService.save(employeeDTO));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CompanyEmployeeDTO> getById(@PathVariable Long id) {
        log.debug("request to get company employee by id: {}", id);
        CompanyEmployeeDTO employeeDTO = companyEmployeeService.findOne(id);
        if (employeeDTO != null) {
            return ResponseEntity.ok(employeeDTO);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CompanyEmployeeDTO> getAll() {
        log.debug("request to get all company employees");
        return companyEmployeeService.findAll();
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public List<CompanyEmployeeDTO> getAllByCompanyId(@PathVariable Long id) {
        log.debug("request to get all employee by company id: {}", id);
        return companyEmployeeService.findAllByCompanyId(id);
    }

    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public List<CompanyEmployeeDTO> getAllByType(@PathVariable EmployeeType type) {
        log.debug("request to get all employees by employee type {}", type);
        return companyEmployeeService.findAllByType(type);
    }

    @RequestMapping(value = "/company/{id}/type/{type}", method = RequestMethod.GET)
    public List<CompanyEmployeeDTO> getAllByCompanyIdAndEmployeeType(@PathVariable Long id,
                                                                     @PathVariable EmployeeType type) {
        log.debug("request to get all company employee by company id: {} and employee type {}", id, type);
        return companyEmployeeService.findAllByCompanyIdAndEmployeeType(id, type);
    }
}
