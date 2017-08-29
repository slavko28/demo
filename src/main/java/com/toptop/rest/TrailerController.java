package com.toptop.rest;

import com.toptop.domain.enums.TrailerType;
import com.toptop.service.TrailerService;
import com.toptop.service.dto.TrailerDTO;
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
@RequestMapping(value = "api/trailer")
public class TrailerController {

    private final Logger log = LoggerFactory.getLogger(TrailerController.class);

    private final TrailerService trailerService;

    @Autowired
    public TrailerController(TrailerService trailerService) {
        this.trailerService = trailerService;
    }

    /**
     * POST / : Create new Trailer.
     *
     * @param trailerDTO the TrailerDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/trailer/all",
     * or with status 400 ("Bad Request") if the TrailerDTO is not valid,
     * or with status 409 ("Conflict") if the TrailerDTO has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody TrailerDTO trailerDTO) throws URISyntaxException {
        log.debug("request to create new trailer: {}", trailerDTO);
        if (trailerDTO.getId() == null) {
            trailerService.save(trailerDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/trailer/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.error("trailer with ID: {} is already exists.", trailerDTO.getId());
        return new ResponseEntity<>("trailer with ID: " + trailerDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Trailer.
     *
     * @param trailerDTO the TrailerDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated CompanyEmployeeDTO,
     * or with status 400 (Bad Request) if the TrailerDTO is not valid,
     * or with status 404 (Not Found) if the trailer couldn't be found
     * @throws IllegalArgumentException in case the given TrailerDTO's ID is {@literal null}.
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody TrailerDTO trailerDTO) {
        log.debug("request to update truck: {}", trailerDTO);
        if (trailerService.isExist(trailerDTO)) {
            return ResponseEntity.ok(trailerService.save(trailerDTO));
        }
        log.error("trailer with ID: {} does not found.", trailerDTO.getId());
        return new ResponseEntity<>("trailer with ID: " + trailerDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /:id : Get Trailer by ID.
     *
     * @param id the Trailer ID
     * @return the ResponseEntity with status 200 (Ok) and with body the TrailerDTO,
     * or with status 404 (Not Found) if the trailer couldn't be found
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        log.debug("request to get trailer by id: {}", id);
        TrailerDTO trailerDTO = trailerService.findOne(id);
        if (trailerDTO != null) {
            return ResponseEntity.ok(trailerDTO);
        }
        log.error("trailer with ID: {} does not found.", id);
        return new ResponseEntity<>("trailer with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : Get all Trailers.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of TrailerDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("request to get all trailers");
        return ResponseEntity.ok(trailerService.findAll());
    }

    /**
     * GET /company/:id : Get all Trailers by company ID.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of TrailerDTO
     */
    @RequestMapping(value = "company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable Long id) {
        log.debug("request to get all trailers by company id {}", id);
        return ResponseEntity.ok(trailerService.findAllByCompanyId(id));
    }

    /**
     * GET /type/:type : Get all Trailers by trailer type.
     *
     * @param type the Trailer type
     * @return the ResponseEntity with status 200 (Ok) and with body the list of TrailerDTO
     */
    @RequestMapping(value = "type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByType(@PathVariable TrailerType type) {
        log.debug("request to get all trailers by trailer type {}", type);
        return ResponseEntity.ok(trailerService.findAllByType(type));
    }

    /**
     * GET /company/:id/type/:type : Get all Trailers by company ID and trailer type.
     *
     * @param id   the company ID
     * @param type the Trailer type
     * @return the ResponseEntity with status 200 (Ok) and with body the list of TrailerDTO
     */
    @RequestMapping(value = "company/{id}/type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyIdAndType(@PathVariable Long id,
                                                   @PathVariable TrailerType type) {
        log.debug("request to get all trailers by company id {}, trailer type {}", id, type);
        return ResponseEntity.ok(trailerService.findAllByCompanyIdAndType(id, type));
    }

}
