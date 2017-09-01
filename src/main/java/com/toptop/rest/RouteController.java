package com.toptop.rest;

import com.toptop.service.RouteService;
import com.toptop.service.dto.RouteDTO;
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
@RequestMapping(value = "api/route")
public class RouteController {

    private final Logger log = LoggerFactory.getLogger(RouteController.class);

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    /**
     * POST / : Create new Route.
     *
     * @param routeDTO the RouteDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/route/all",
     * or with status 400 ("Bad Request") if the routeDTO is not valid,
     * or with status 409 ("Conflict") if the Route has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody RouteDTO routeDTO) throws URISyntaxException {
        log.debug("request to create new route : {}", routeDTO);
        if (routeDTO.getId() == null) {
            routeService.save(routeDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/route/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.error("route with ID: {} is already exists.", routeDTO.getId());
        return new ResponseEntity<>("route with ID: " + routeDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Route.
     *
     * @param routeDTO the RouteDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated RouteDTO,
     * or with status 400 (Bad Request) if the RouteDTO is not valid,
     * or with status 404 (Not Found) if the route couldn't be found
     * @throws IllegalArgumentException in case the given RouteDTO's ID is null.
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody RouteDTO routeDTO) {
        log.debug("request to update route: {}", routeDTO);
        Assert.notNull(routeDTO.getId(), "ID can not be null.");
        if (routeService.isExist(routeDTO)) {
            return ResponseEntity.ok(routeService.save(routeDTO));
        }
        log.error("route : {} does not found.", routeDTO);
        return new ResponseEntity<>("route: " + routeDTO + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * DET /:id : Get Route by ID.
     *
     * @param id the Route ID
     * @return the ResponseEntity with status 200 (Ok) and with body the RouteDTO,
     * or with status 404 (Not Found) if the route couldn't be found
     * @throws IllegalArgumentException in case the given ID is null.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        log.debug("request to get route by id: {}", id);
        Assert.notNull(id, "ID can not be null.");
        RouteDTO routeDTO = routeService.findOne(id);
        if (routeDTO != null) {
            return ResponseEntity.ok(routeDTO);
        }
        log.error("route with ID: {} does not found.", id);
        return new ResponseEntity<>("route with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : GET all Route.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of RouteDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("Request to get all routes");
        return ResponseEntity.ok(routeService.findAll());
    }
}
