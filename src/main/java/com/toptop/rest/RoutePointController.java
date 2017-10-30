package com.toptop.rest;

import com.toptop.service.RoutePointService;
import com.toptop.service.dto.RoutePointDTO;
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
import java.util.Optional;

@RestController
@RequestMapping(value = "api/point")
public class RoutePointController {

    private static final Logger LOG = LoggerFactory.getLogger(RoutePointController.class);

    private RoutePointService routePointService;

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
        LOG.debug("request to create new route point : {}", pointDTO);
        if (pointDTO.getId() == null) {
            routePointService.save(pointDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/point/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        LOG.error("route point with ID: {} is already exists.", pointDTO.getId());
        return new ResponseEntity<>("route point with ID: " + pointDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Route point.
     *
     * @param pointDTO the RoutePointDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated RoutePointDTO,
     * or with status 400 (Bad Request) if the RoutePointDTO is not valid,
     * or with status 404 (Not Found) if the route point couldn't be found
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody RoutePointDTO pointDTO) {
        LOG.debug("request to update route point : {}", pointDTO);
        Optional<RoutePointDTO> maybeRoutePoint = routePointService.findOne(pointDTO.getId());
        if (maybeRoutePoint.isPresent()) {
            return ResponseEntity.ok(routePointService.save(pointDTO));
        }
        LOG.error("route point: {} does not found.", pointDTO);
        return new ResponseEntity<>("route point: " + pointDTO + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * DET /:id : Get Route point by ID.
     *
     * @param id the Route point ID
     * @return the ResponseEntity with status 200 (Ok) and with body the RoutePointDTO,
     * or with status 404 (Not Found) if the route point couldn't be found
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        LOG.debug("request to get route point by id: {}", id);
        Optional<RoutePointDTO> maybeRoutePoint = routePointService.findOne(id);
        if (maybeRoutePoint.isPresent()) {
            return ResponseEntity.ok(maybeRoutePoint.get());
        }
        LOG.error("route point with ID: {} does not found.", id);
        return new ResponseEntity<>("route point with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : GET all Route point.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of RoutePointDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        LOG.debug("Request to get all Route points");
        return ResponseEntity.ok(routePointService.findAll());
    }
}
