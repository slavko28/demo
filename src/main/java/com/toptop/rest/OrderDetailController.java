package com.toptop.rest;

import com.toptop.service.OrderDetailService;
import com.toptop.service.dto.OrderDetailDTO;
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
@RequestMapping(value = "api/detail")
public class OrderDetailController {

    private final Logger log = LoggerFactory.getLogger(OrderDetailController.class);

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * POST / : Create new Order detail.
     *
     * @param orderDetailDTO the OrderDetailDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/detail/all",
     * or with status 400 ("Bad Request") if the OrderDetailDTO is not valid,
     * or with status 409 ("Conflict") if the OrderDetailDTO has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody OrderDetailDTO orderDetailDTO) throws URISyntaxException {
        log.debug("request to create new Order detail: {}", orderDetailDTO);
        if (orderDetailDTO.getId() == null) {
            orderDetailService.save(orderDetailDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("api/detail/all"));
            return new ResponseEntity(headers, HttpStatus.CREATED);
        }
        log.error("order detail with ID: {} is already exists.", orderDetailDTO.getId());
        return new ResponseEntity<>("order detail with ID: " + orderDetailDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Order detail.
     *
     * @param orderDetailDTO the OrderDetailDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated OrderDetailDTO,
     * or with status 400 (Bad Request) if the OrderDetailDTO is not valid,
     * or with status 404 (Not Found) if the Order detail couldn't be found
     * @throws IllegalArgumentException in case the given OrderDetailDTO's ID is null.
     */
    public ResponseEntity update(@Valid @RequestBody OrderDetailDTO orderDetailDTO) {
        log.debug("request to update Order detail {}", orderDetailDTO);
        Assert.notNull(orderDetailDTO.getId(), "ID can not be null");
        if (orderDetailService.isExist(orderDetailDTO)) {
            return ResponseEntity.ok(orderDetailService.save(orderDetailDTO));
        }
        log.error("order detail with ID: {} couldn't be found.");
        return new ResponseEntity<>("order detail with ID: " + orderDetailDTO.getId() + " does not found.", HttpStatus.CONFLICT);
    }

    /**
     * GET /:id : Get Order detail by ID.
     *
     * @param id the Order detail ID
     * @return the ResponseEntity with status 200 (Ok) and with body the OrderDetailDTO,
     * or with status 404 (Not Found) if the order detail couldn't be found
     * @throws IllegalArgumentException if the ID is null
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        log.debug("request to get order detail by ID: {}", id);
        Assert.notNull(id, "ID can not be null");
        OrderDetailDTO orderDetailDTO = orderDetailService.findOne(id);
        if (orderDetailDTO != null) {
            return ResponseEntity.ok(orderDetailDTO);
        }
        log.error("order detail with ID: {} does not found.", id);
        return new ResponseEntity<>("order's detail with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : Get all Order detail entities.
     *
     * @return the ResponseEntity with status 200 (ok) and with body the list of OrderDetailDTO
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("request to get all order detail entities");
        return ResponseEntity.ok(orderDetailService.findAll());
    }

    /**
     * GET /manager/:id : Get all Order's detail by User (manager) ID.
     *
     * @param id the User (manager) ID
     * @return the ResponseEntity with status 200 (ok) and with body the list of OrderDetailDTO
     * @throws IllegalArgumentException if the ID is null
     */
    @RequestMapping(value = "manager/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByManagerId(@PathVariable Long id) {
        log.debug("request to find all order's detail by user ID: {}", id);
        Assert.notNull(id, "ID can not be null");
        return ResponseEntity.ok(orderDetailService.findAllByManagerId(id));
    }

    /**
     * GET /driver/:id : Get all Order's detail by Company employee (driver) ID.
     *
     * @param id the Company employee (driver) ID
     * @return the ResponseEntity with status 200 (ok) and with body the list of OrderDetailDTO
     * @throws IllegalArgumentException if the ID is null
     */
    @RequestMapping(value = "/driver/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByDriverId(@PathVariable Long id) {
        log.debug("request to find all order's detail by company employee ID: {}", id);
        Assert.notNull(id, "ID can not be null");
        return ResponseEntity.ok(orderDetailService.findAllByDriverId(id));
    }

}
