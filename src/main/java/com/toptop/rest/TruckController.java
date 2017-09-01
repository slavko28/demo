package com.toptop.rest;

import com.toptop.service.TruckService;
import com.toptop.service.dto.TruckDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/truck")
public class TruckController {

    private final Logger log = LoggerFactory.getLogger(TruckController.class);

    private final TruckService truckService;

    @Autowired
    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    /**
     * POST / : Create new Truck.
     *
     * @param truckDTO the TruckDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/truck/all",
     * or with status 400 ("Bad Request") if the TruckDTO is not valid,
     * or with status 409 ("Conflict") if the TruckDTO has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody TruckDTO truckDTO) throws URISyntaxException {
        log.debug("request to create new truck: {}", truckDTO);
        if (truckDTO.getId() == null) {
            truckService.save(truckDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/truck/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.error("truck with ID: {} is already exists.", truckDTO.getId());
        return new ResponseEntity<>("truck with ID: " + truckDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Truck.
     *
     * @param truckDTO the TruckDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated TruckDTO,
     * or with status 400 (Bad Request) if the TruckDTO is not valid,
     * or with status 404 (Not Found) if the truck couldn't be found
     * @throws IllegalArgumentException in case the given TruckDTO's ID is {@literal null}.
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody TruckDTO truckDTO) {
        log.debug("request to update truck: {}", truckDTO);
        if (truckService.isExist(truckDTO)) {
            return ResponseEntity.ok(truckService.save(truckDTO));
        }
        log.error("truck with ID: {} does not found.", truckDTO.getId());
        return new ResponseEntity<>("truck with ID: " + truckDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /:id : Get Truck by ID.
     *
     * @param id the Truck ID
     * @return the ResponseEntity with status 200 (Ok) and with body the TruckDTO,
     * or with status 404 (Not Found) if the truck couldn't be found
     * @throws IllegalArgumentException in case the given ID is null.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        log.debug("request to get truck by id: {}", id);
        Assert.notNull(id, "ID can not be null.");
        TruckDTO truck = truckService.findOne(id);
        if (truck != null) {
            return ResponseEntity.ok(truck);
        }
        log.error("truck with ID: {} does not found.", id);
        return new ResponseEntity<>("truck with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : Get all Trucks.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of TruckDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("request to get all trucks");
        return ResponseEntity.ok(truckService.findAll());
    }

    /**
     * GET /company/:id : Get all Trucks by company ID.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of TruckDTO
     * @throws IllegalArgumentException in case the given ID is null.
     */
    @RequestMapping(value = "company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable Long id) {
        log.debug("request to get all trucks by company id {}", id);
        Assert.notNull(id, "ID can not be null.");
        return ResponseEntity.ok(truckService.findAllByCompanyId(id));
    }
}
