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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "api/trailer")
public class TrailerController {

    private final Logger log = LoggerFactory.getLogger(TrailerController.class);

    @Autowired
    private TrailerService trailerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Validated @RequestBody TrailerDTO trailerDTO, UriComponentsBuilder builder) {
        log.debug("request to create new trailer: {}", trailerDTO);
        if (trailerDTO.getId() == null) {
            trailerService.save(trailerDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/api/trailer/all").build().toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        log.debug("trailer with ID: {} is already exists.", trailerDTO.getId());
        return new ResponseEntity<>("trailer with ID: " + trailerDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Validated @RequestBody TrailerDTO trailerDTO) {
        log.debug("request to update truck: {}", trailerDTO);
        if (trailerService.isExist(trailerDTO)) {
            return ResponseEntity.ok(trailerService.save(trailerDTO));
        }
        log.debug("trailer with ID: {} does not found.", trailerDTO.getId());
        return new ResponseEntity<>("trailer with ID: " + trailerDTO.getId() + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {
        log.debug("request to get trailer by id: {}", id);
        TrailerDTO trailerDTO = trailerService.findOne(id);
        if (trailerDTO != null) {
            return ResponseEntity.ok(trailerDTO);
        }
        log.debug("trailer with ID: {} does not found.", id);
        return new ResponseEntity<>("trailer with ID: " + id + " does not found.", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getAll() {
        log.debug("request to get all trailers");
        return ResponseEntity.ok(trailerService.findAll());
    }

    @RequestMapping(value = "company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable Long id) {
        log.debug("request to get all trailers by company id {}", id);
        return ResponseEntity.ok(trailerService.findAllByCompanyId(id));
    }

    @RequestMapping(value = "type/{type}/", method = RequestMethod.GET)
    public ResponseEntity getAllByType(@PathVariable TrailerType type) {
        log.debug("request to get all trailers by trailer type {}", type);
        return ResponseEntity.ok(trailerService.findAllByType(type));
    }

    @RequestMapping(value = "company/{id}/type/{type}/", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyIdAndType(@PathVariable Long id, TrailerType type) {
        log.debug("request to get all trailers by company id {}, trailer type {}", id, type);
        return ResponseEntity.ok(trailerService.findAllByCompanyIdAndType(id, type));
    }

}
