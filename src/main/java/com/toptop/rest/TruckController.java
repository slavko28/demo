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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/truck")
public class TruckController {

    private static final Logger LOG = LoggerFactory.getLogger(TruckController.class);

    private TruckService truckService;

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
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody TruckDTO truckDTO) throws URISyntaxException {
        LOG.debug("request to create new truck: {}", truckDTO);
        if (truckDTO.getId() == null) {
            truckService.save(truckDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/truck/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        LOG.error("truck with ID: {} is already exists.", truckDTO.getId());
        return new ResponseEntity<>("truck with ID: " + truckDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Truck.
     *
     * @param truckDTO the TruckDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated TruckDTO,
     * or with status 400 (Bad Request) if the TruckDTO is not valid,
     * or with status 404 (Not Found) if the truck couldn't be found
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody TruckDTO truckDTO) {
        LOG.debug("request to update truck: {}", truckDTO);
        Optional<TruckDTO> maybeTruck = truckService.findOne(truckDTO.getId());
        if (maybeTruck.isPresent()) {
            return ResponseEntity.ok(truckService.save(truckDTO));
        }
        LOG.error("truck with ID: {} does not found.", truckDTO.getId());
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
        LOG.debug("request to get truck by id: {}", id);
        Optional<TruckDTO> maybeTruck = truckService.findOne(id);
        if (maybeTruck.isPresent()) {
            return ResponseEntity.ok(maybeTruck.get());
        }
        LOG.error("truck with ID: {} does not found.", id);
        return new ResponseEntity<>("truck with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : Get all Trucks.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of TruckDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        LOG.debug("request to get all trucks");
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
        LOG.debug("request to get all trucks by company id {}", id);
        Assert.notNull(id, "ID can not be null.");
        return ResponseEntity.ok(truckService.findAllByCompanyId(id));
    }
}
