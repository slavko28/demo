package com.toptop.rest;

import com.toptop.domain.enums.OrderStatus;
import com.toptop.service.CompanyOrderService;
import com.toptop.service.dto.CompanyOrderDTO;
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
import java.util.List;

@RestController
@RequestMapping(value = "/api/order")
public class CompanyOrderController {

    private final Logger log = LoggerFactory.getLogger(CompanyOrderController.class);

    private final CompanyOrderService orderService;

    @Autowired
    public CompanyOrderController(CompanyOrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * POST / : Create new Company order.
     *
     * @param orderDTO the CompanyOrderDTO to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/order/all",
     * or with status 400 ("Bad Request") if the CompanyOrderDTO is not valid,
     * or with status 409 ("Conflict") if the CompanyOrderDTO has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody CompanyOrderDTO orderDTO) throws URISyntaxException {
        log.debug("request to create new order: {}", orderDTO);
        if (orderDTO.getId() == null) {
            orderService.save(orderDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("api/order/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.error("order with ID: {} is already exists.", orderDTO.getId());
        return new ResponseEntity<>("Order with ID:" + orderDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing Company order.
     *
     * @param orderDTO the CompanyOrderDTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated CompanyOrderDTO,
     * or with status 400 (Bad Request) if the CompanyOrderDTO is not valid,
     * or with status 404 (Not Found) if the order couldn't be found
     * @throws IllegalArgumentException in case the given CompanyOrderDTO's ID is null.
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody CompanyOrderDTO orderDTO) {
        log.debug("request to update Order : {}", orderDTO);
        Assert.notNull(orderDTO.getId(), "ID can not be null");
        if (orderService.isExist(orderDTO)) {
            return ResponseEntity.ok(orderService.save(orderDTO));
        }
        log.error("order: {} does not found.", orderDTO);
        return new ResponseEntity<>("order: " + orderDTO + " - does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : Get all Company orders.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of CompanyOrderDTO,
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        log.debug("request to get all Company orders");
        List<CompanyOrderDTO> list = orderService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * GET /:id : Get Company order by ID.
     *
     * @param id the Company order ID
     * @return the ResponseEntity with status 200 (Ok) and with body the CompanyOrderDTO,
     * or with status 404 (Not Found) if the order couldn't be found
     * @throws IllegalArgumentException in case the given ID is null.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        log.debug("request to get Company order by id :{}", id);
        Assert.notNull(id, "ID can not be null");
        CompanyOrderDTO orderDTO = orderService.findOne(id);
        if (orderDTO != null) {
            return ResponseEntity.ok(orderDTO);
        }
        log.error("order with ID: {} does not found.", id);
        return new ResponseEntity<>("order with ID: " + id + " - does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * Get /manager/:id : Get all Company orders entities by company employee ID.
     *
     * @param id the Company employee ID
     * @return the ResponseEntity with status 200 (ok) and with body the list of CompanyOrderDTO.
     * @throws IllegalArgumentException in case the given Company employee's ID is null.
     */
    @RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyEmployeeId(@PathVariable("id") Long id) {
        log.debug("request to get all orders by Company employee ID: {}", id);
        Assert.notNull(id, "ID can not be null");
        return ResponseEntity.ok(orderService.findAllByCompanyEmployeeId(id));
    }

    /**
     * Get /company/:id : Get all Company orders by company ID.
     *
     * @param id the Company ID
     * @return the ResponseEntity with status 200 (ok) and with body the list of CompanyOrderDTO.
     * @throws IllegalArgumentException in case the given Company's ID is null.
     */
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable("id") Long id) {
        log.debug("request to get all CompanyOrder entities by company ID: {}", id);
        Assert.notNull(id, "ID can not be null");
        return ResponseEntity.ok(orderService.findAllByCompanyId(id));
    }

    /**
     * Get /status/:status : Get all Company orders by Order status.
     *
     * @param status the Order status
     * @return the ResponseEntity with status 200 (ok) and with body the list of CompanyOrderDTO.
     * @throws IllegalArgumentException in case the given Order's status type is null.
     */
    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public ResponseEntity getAllByOrderStatus(@PathVariable("status") OrderStatus status) {
        log.debug("request to get all CompanyOrder entities by Order status: {}", status);
        Assert.notNull(status, "Status can not be null");
        return ResponseEntity.ok(orderService.findAllByStatus(status));
    }
}
