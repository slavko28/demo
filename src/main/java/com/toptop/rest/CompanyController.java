package com.toptop.rest;

import com.toptop.service.CompanyService;
import com.toptop.service.dto.CompanyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final Logger log = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CompanyDTO> create(@Validated @RequestBody CompanyDTO companyDTO) {
        log.debug("REST request to create new Company : {}", companyDTO);
        if (companyDTO.getId() == null) {
            return ResponseEntity.ok(companyService.save(companyDTO));
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<CompanyDTO> update(@Validated @RequestBody CompanyDTO companyDTO) {
        log.debug("REST request to update Company : {}", companyDTO);
        if (companyService.isExist(companyDTO)) {
            return ResponseEntity.ok(companyService.save(companyDTO));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<CompanyDTO> getById(@PathVariable("id") Long id) {
        log.debug("Request to get Company by id: {}", id);
        CompanyDTO companyDTO = companyService.findOne(id);
        if (companyDTO != null) {
            return ResponseEntity.ok(companyDTO);
        }
        return new ResponseEntity<CompanyDTO>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<CompanyDTO> getAll() {
        log.debug("REST request to get all Companies");
        return companyService.findAll();
    }
}
