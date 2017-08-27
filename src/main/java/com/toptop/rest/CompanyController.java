package com.toptop.rest;

import com.toptop.service.CompanyService;
import com.toptop.service.dto.CompanyDTO;
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
@RequestMapping("/api/company")
public class CompanyController {

    private final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Validated @RequestBody CompanyDTO companyDTO, UriComponentsBuilder builder) {
        log.debug("request to create new Company : {}", companyDTO);
        if (companyDTO.getId() == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/api/company/all").build().toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.debug("company with ID: {} is already exists.", companyDTO.getId());
        return new ResponseEntity<>("company with ID: " + companyDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Validated @RequestBody CompanyDTO companyDTO) {
        log.debug("request to update Company : {}", companyDTO);
        if (companyService.isExist(companyDTO)) {
            return ResponseEntity.ok(companyService.save(companyDTO));
        }
        log.debug("company with name: {} does not found.", companyDTO.getShortName());
        return new ResponseEntity<>("company with ID: " + companyDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        log.debug("Request to get Company by id: {}", id);
        CompanyDTO companyDTO = companyService.findOne(id);
        if (companyDTO != null) {
            return ResponseEntity.ok(companyDTO);
        }
        log.debug("company with ID: {} does not found.", id);
        return new ResponseEntity<>("company with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cod/{companyCod}", method = RequestMethod.GET)
    public ResponseEntity getByCompanyCod(@PathVariable("companyCod") Long companyCod) {
        log.debug("Request to get Company by company cod: {}", companyCod);
        CompanyDTO companyDTO = companyService.findByOneByCompanyCod(companyCod);
        if (companyDTO != null) {
            return ResponseEntity.ok(companyDTO);
        }
        log.debug("company with Cod: {} does not found.", companyCod);
        return new ResponseEntity<>("company with cod: " + companyCod + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("request to get all Companies");
        return ResponseEntity.ok(companyService.findAll());
    }
}
