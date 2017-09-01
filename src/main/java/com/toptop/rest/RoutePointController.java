package com.toptop.rest;

import com.toptop.service.RoutePointService;
import com.toptop.service.dto.RoutePointDTO;
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

@RestController
@RequestMapping(value = "api/point")
public class RoutePointController {

    private final Logger log = LoggerFactory.getLogger(RoutePointController.class);

    private final RoutePointService routePointService;

    @Autowired
    public RoutePointController(RoutePointService routePointService) {
        this.routePointService = routePointService;
    }

    /**
     * POST / : Create new Route point.
     *
     * @param pointDTO the RoutePointDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/point/all",
     * or with status 400 ("Bad Request") if the RoutePointDTO is not valid,
     * or with status 409 ("Conflict") if the route point has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody RoutePointDTO pointDTO) throws URISyntaxException {
        log.debug("request to create new route point : {}", pointDTO);
        if (pointDTO.getId() == null) {
            routePointService.save(pointDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/point/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.error("route point with ID: {} is already exists.", pointDTO.getId());
        return new ResponseEntity<>("route point with ID: " + pointDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Route point.
     *
     * @param pointDTO the RoutePointDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated RoutePointDTO,
     * or with status 400 (Bad Request) if the RoutePointDTO is not valid,
     * or with status 404 (Not Found) if the route point couldn't be found
     * @throws IllegalArgumentException in case the given RoutePointDTO's ID is {@literal null}.
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody RoutePointDTO pointDTO) {
        log.debug("request to update route point : {}", pointDTO);
        if (routePointService.isExist(pointDTO)) {
            return ResponseEntity.ok(routePointService.save(pointDTO));
        }
        log.error("route point: {} does not found.", pointDTO);
        return new ResponseEntity<>("route point: " + pointDTO + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * DET /:id : Get Route point by ID.
     *
     * @param id the Route point ID
     * @return the ResponseEntity with status 200 (Ok) and with body the RoutePointDTO,
     * or with status 404 (Not Found) if the route point couldn't be found
     * @throws IllegalArgumentException in case the given ID is null.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        log.debug("request to get route point by id: {}", id);
        Assert.notNull(id, "ID can not be null.");
        RoutePointDTO pointDTO = routePointService.findOne(id);
        if (pointDTO != null) {
            return ResponseEntity.ok(pointDTO);
        }
        log.error("route point with ID: {} does not found.", id);
        return new ResponseEntity<>("route point with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : GET all Route point.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of RoutePointDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("Request to get all Route points");
        return ResponseEntity.ok(routePointService.findAll());
    }
}
