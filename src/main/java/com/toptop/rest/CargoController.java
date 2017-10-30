package com.toptop.rest;

import com.toptop.service.CargoService;
import com.toptop.service.dto.CargoDTO;
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
@RequestMapping("/api/cargo")
public class CargoController {

    private static final Logger LOG = LoggerFactory.getLogger(CargoController.class);

    private CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    /**
     * POST / : Create new Cargo.
     *
     * @param cargoDTO the CargoDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/cargo/all",
     * or with status 400 ("Bad Request") if the CargoDTO is not valid,
     * or with status 409 ("Conflict") if the CargoDTO has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody CargoDTO cargoDTO) throws URISyntaxException {
        LOG.debug("request to create new Cargo: {}", cargoDTO);
        if (cargoDTO.getId() == null) {
            cargoService.save(cargoDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/cargo/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        LOG.error("cargo with ID: {} is already exists.", cargoDTO.getId());
        return new ResponseEntity<>("cargo with ID: " + cargoDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Cargo.
     *
     * @param cargoDTO the Cargo to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated cargoDTO,
     * or with status 400 (Bad Request) if the cargoDTO is not valid,
     * or with status 404 (Not Found) if the cargo couldn't be found
     **/
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody CargoDTO cargoDTO) {
        LOG.debug("request to update Cargo : {}", cargoDTO);
        Optional<CargoDTO> maybeCargo = cargoService.findOne(cargoDTO.getId());
        if (maybeCargo.isPresent()) {
            return ResponseEntity.ok(cargoService.save(cargoDTO));
        }
        LOG.error("cargo with ID: {} does not found.", cargoDTO.getId());
        return new ResponseEntity<>("cargo with ID: " + cargoDTO.getId() + " - does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /:id : Get cargo by ID.
     *
     * @param id the cargo ID
     * @return the ResponseEntity with status 200 (Ok) and with body the CargoDTO,
     * or with status 404 (Not Found) if the cargo couldn't be found
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        LOG.debug("request to get Cargo by ID: {}", id);
       Optional<CargoDTO> maybeCargo = cargoService.findOne(id);
        if (maybeCargo.isPresent()) {
            return ResponseEntity.ok(maybeCargo.get());
        }
        LOG.error("cargo with ID: {} does not found.", id);
        return new ResponseEntity<>("cargo with ID: " + id + " - does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : Get all Cargo entities.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of Cargo entities.
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        LOG.debug("request to get all Cargo entities.");
        return ResponseEntity.ok(cargoService.findAll());
    }

    /**
     * Get /company/:id : Get all Cargo entities by company ID.
     *
     * @param id the Company ID
     * @return the ResponseEntity with status 200 (ok) and with body the list of Cargo entities.
     * @throws IllegalArgumentException in case the given Company's ID is null.
     */
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable Long id) {
        LOG.debug("request to get all Cargo entities by company ID: {}", id);
        Assert.notNull(id, "ID can not be null");
        return ResponseEntity.ok(cargoService.findAllByCompanyId(id));
    }

}



