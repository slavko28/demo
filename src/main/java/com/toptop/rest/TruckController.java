package com.toptop.rest;

import com.toptop.service.TruckService;
import com.toptop.service.dto.TruckDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/truck")
public class TruckController {

    private final Logger log = LoggerFactory.getLogger(TruckController.class);

    @Autowired
    private TruckService truckService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Validated @RequestBody TruckDTO truckDTO, UriComponentsBuilder builder) {
        log.debug("request to create new truck: {}", truckDTO);
        if (truckDTO.getId() == null) {
            truckService.save(truckDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/api/truck/all").build().toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.debug("truck with ID: {} is already exists.", truckDTO.getId());
        return new ResponseEntity<>("truck with ID: " + truckDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Validated @RequestBody TruckDTO truckDTO) {
        log.debug("request to update truck: {}", truckDTO);
        if (truckService.isExist(truckDTO)) {
            return ResponseEntity.ok(truckService.save(truckDTO));
        }
        log.debug("truck with ID: {} does not found.", truckDTO.getId());
        return new ResponseEntity<>("truck with ID: " + truckDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        log.debug("request to get truck by id: {}", id);
        TruckDTO truck = truckService.findOne(id);
        if (truck != null) {
            return ResponseEntity.ok(truck);
        }
        log.debug("truck with ID: {} does not found.", id);
        return new ResponseEntity<>("truck with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("request to get all trucks");
        return ResponseEntity.ok(truckService.findAll());
    }

    @RequestMapping(value = "company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable Long id) {
        log.debug("request to get all trucks by company id {}", id);
        return ResponseEntity.ok(truckService.findAllByCompanyId(id));
    }
}
