package com.toptop.rest;

import com.toptop.service.CompanyService;
import com.toptop.service.dto.CompanyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final Logger log = LoggerFactory.getLogger(CompanyController.class);

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * POST / : Create new Company.
     *
     * @param companyDTO the CompanyDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/company/all",
     * or with status 400 ("Bad Request") if the companyDTO is not valid,
     * or with status 409 ("Conflict") if the company has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody CompanyDTO companyDTO) throws URISyntaxException {
        log.debug("request to create new company : {}", companyDTO);
        if (companyDTO.getId() == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/company/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.error("company with ID: {} is already exists.", companyDTO.getId());
        return new ResponseEntity<>("company with ID: " + companyDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Company.
     *
     * @param companyDTO the CompanyDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated companyDTO,
     * or with status 400 (Bad Request) if the companyDTO is not valid,
     * or with status 404 (Not Found) if the company couldn't be found
     * @throws IllegalArgumentException in case the given CompanyDTO's ID is {@literal null}.
     **/
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody CompanyDTO companyDTO) {
        log.debug("request to update company : {}", companyDTO);
        if (companyService.isExist(companyDTO)) {
            return ResponseEntity.ok(companyService.save(companyDTO));
        }
        log.error("company with name: {} does not found.", companyDTO.getShortName());
        return new ResponseEntity<>("company with ID: " + companyDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * DET /:id : Get Company by ID.
     *
     * @param id the Company ID
     * @return the ResponseEntity with status 200 (Ok) and with body the CompanyDTO,
     * or with status 404 (Not Found) if the company couldn't be found
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        log.debug("request to get company by id: {}", id);
        CompanyDTO companyDTO = companyService.findOne(id);
        if (companyDTO != null) {
            return ResponseEntity.ok(companyDTO);
        }
        log.error("company with ID: {} does not found.", id);
        return new ResponseEntity<>("company with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /cod/:companyCod : Get Company by company cod.
     *
     * @param companyCod the company cod
     * @return the ResponseEntity with status 200 (Ok) and with body the CompanyDTO,
     * or with status 404 (Not Found) if the company couldn't be found
     */
    @RequestMapping(value = "/cod/{companyCod}", method = RequestMethod.GET)
    public ResponseEntity getByCompanyCod(@PathVariable("companyCod") Long companyCod) {
        log.debug("Request to get company by company cod: {}", companyCod);
        CompanyDTO companyDTO = companyService.findByOneByCompanyCod(companyCod);
        if (companyDTO != null) {
            return ResponseEntity.ok(companyDTO);
        }
        log.error("company with Cod: {} does not found.", companyCod);
        return new ResponseEntity<>("company with cod: " + companyCod + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : GET all Company.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of CompanyDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("Request to get all companies");
        return ResponseEntity.ok(companyService.findAll());
    }
}
