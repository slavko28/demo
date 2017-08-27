package com.toptop.rest;

import com.toptop.domain.enums.EmployeeType;
import com.toptop.service.CompanyEmployeeService;
import com.toptop.service.dto.CompanyEmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/employee")
public class CompanyEmployeeController {

    private final Logger log = LoggerFactory.getLogger(CompanyEmployeeController.class);

    @Autowired
    private CompanyEmployeeService companyEmployeeService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Validated @RequestBody CompanyEmployeeDTO employeeDTO, UriComponentsBuilder builder) {
        log.debug("request to create mew company employee: {}", employeeDTO);
        if (employeeDTO.getId() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/api/employee/all").build().toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.debug("employee with ID: {} is already exists.", employeeDTO.getId());
        return new ResponseEntity<>("Employee with ID: " + employeeDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Validated @RequestBody CompanyEmployeeDTO employeeDTO) {
        log.debug("request to update company employee {}", employeeDTO);
        if (companyEmployeeService.isExist(employeeDTO)) {
            return ResponseEntity.ok(companyEmployeeService.save(employeeDTO));
        }
        log.debug("employee with ID: {} does not found.", employeeDTO.getId());
        return new ResponseEntity<>("employee with ID: " + employeeDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        log.debug("request to get company employee by id: {}", id);
        CompanyEmployeeDTO employeeDTO = companyEmployeeService.findOne(id);
        if (employeeDTO != null) {
            return ResponseEntity.ok(employeeDTO);
        }
        log.debug("employee with ID: {} does not found.", id);
        return new ResponseEntity<>("employee with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("request to get all company employees");
        return ResponseEntity.ok(companyEmployeeService.findAll());
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable Long id) {
        log.debug("request to get all employee by company id: {}", id);
        return ResponseEntity.ok(companyEmployeeService.findAllByCompanyId(id));
    }

    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByType(@PathVariable EmployeeType type) {
        log.debug("request to get all employees by employee type {}", type);
        return ResponseEntity.ok(companyEmployeeService.findAllByType(type));
    }

    @RequestMapping(value = "/company/{id}/type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyIdAndEmployeeType(@PathVariable Long id,
                                                           @PathVariable EmployeeType type) {
        log.debug("request to get all company employee by company id: {} and employee type {}", id, type);
        return ResponseEntity.ok(companyEmployeeService.findAllByCompanyIdAndEmployeeType(id, type));
    }
}
