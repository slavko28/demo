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
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class CompanyEmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyEmployeeController.class);

    private CompanyEmployeeService companyEmployeeService;

    @Autowired
    public CompanyEmployeeController(CompanyEmployeeService companyEmployeeService) {
        this.companyEmployeeService = companyEmployeeService;
    }

    /**
     * POST / : Create new Company employee.
     *
     * @param employeeDTO the CompanyEmployeeDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/employee/all",
     * or with status 400 ("Bad Request") if the CompanyEmployeeDTO is not valid,
     * or with status 409 ("Conflict") if the CompanyEmployeeDTO has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody CompanyEmployeeDTO employeeDTO) throws URISyntaxException {
        LOG.debug("request to create mew company employee: {}", employeeDTO);
        if (employeeDTO.getId() != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/employee/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        LOG.error("employee with ID: {} is already exists.", employeeDTO.getId());
        return new ResponseEntity<>("Employee with ID: " + employeeDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Company employee.
     *
     * @param employeeDTO the CompanyEmployeeDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated CompanyEmployeeDTO,
     * or with status 400 (Bad Request) if the CompanyEmployeeDTO is not valid,
     * or with status 404 (Not Found) if the company employee couldn't be found
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody CompanyEmployeeDTO employeeDTO) {
        LOG.debug("request to update company employee {}", employeeDTO);
        Optional<CompanyEmployeeDTO> maybeEmployee = companyEmployeeService.findOne(employeeDTO.getId());
        if (maybeEmployee.isPresent()) {
            return ResponseEntity.ok(companyEmployeeService.save(employeeDTO));
        }
        LOG.error("employee with ID: {} does not found.", employeeDTO.getId());
        return new ResponseEntity<>("employee with ID: " + employeeDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /:id : Get Company employee by ID.
     *
     * @param id the Company employee ID
     * @return the ResponseEntity with status 200 (Ok) and with body the CompanyEmployeeDTO,
     * or with status 404 (Not Found) if the company employee couldn't be found
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        LOG.debug("request to get company employee by id: {}", id);
        Optional<CompanyEmployeeDTO> maybeEmployee = companyEmployeeService.findOne(id);
        if (maybeEmployee.isPresent()) {
            return ResponseEntity.ok(maybeEmployee.get());
        }
        LOG.error("employee with ID: {} does not found.", id);
        return new ResponseEntity<>("employee with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : Get all Company employees.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of CompanyEmployeeDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        LOG.debug("request to get all employees");
        return ResponseEntity.ok(companyEmployeeService.findAll());
    }

    /**
     * GET /company/:id : Get all Company employees by company ID.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of CompanyEmployeeDTO
     * @throws IllegalArgumentException in case the given Company's ID is null.
     */
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable("id") Long id) {
        LOG.debug("request to get all employee by company id: {}", id);
        Assert.notNull(id, "ID can not be null");
        return ResponseEntity.ok(companyEmployeeService.findAllByCompanyId(id));
    }

    /**
     * GET /type/:type : Get all Company employees by employee type.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of CompanyEmployeeDTO
     * @throws IllegalArgumentException in case the given Employee's type is null.

     */
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByType(@PathVariable("type") EmployeeType type) {
        LOG.debug("request to get all employees by type {}", type);
        Assert.notNull(type, "Type can not be null");
        return ResponseEntity.ok(companyEmployeeService.findAllByType(type));
    }

    /**
     * GET /company/:id/type/:type : Get all Company employees by company ID and employee type.
     *
     * @param id   the company ID
     * @param type the Employee type
     * @return the ResponseEntity with status 200 (Ok) and with body the list of CompanyEmployeeDTO
     * @throws IllegalArgumentException in case the given Company's ID or Employee's type is null.
     */
    @RequestMapping(value = "/company/{id}/type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyIdAndEmployeeType(@PathVariable("id") Long id,
                                                           @PathVariable("type") EmployeeType type) {
        LOG.debug("request to get all employee by company id: {} and employee type {}", id, type);
        Assert.notNull(id, "ID can not be null");
        Assert.notNull(type, "Type can not be null");
        return ResponseEntity.ok(companyEmployeeService.findAllByCompanyIdAndEmployeeType(id, type));
    }
}
