package com.toptop.rest;

import com.toptop.domain.enums.AddressType;
import com.toptop.service.AddressService;
import com.toptop.service.dto.AddressDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final Logger log = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AddressDTO> create(@Validated @RequestBody AddressDTO addressDTO) {
        log.debug("REST request to save Address : {}", addressDTO);
        if (addressDTO.getId() == null) {
            return ResponseEntity.ok(addressService.save(addressDTO));
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<AddressDTO> update(@Validated @RequestBody AddressDTO addressDTO) {
        log.debug("REST request to update Address : {}", addressDTO);
        if (addressService.isExist(addressDTO)) {
            return ResponseEntity.ok(addressService.save(addressDTO));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        log.debug("REST request to get all Addresses");
        List<AddressDTO> list = addressService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AddressDTO> getById(@PathVariable("id") Long id) {
        log.debug("REST request to get Address by id :{}", id);
        AddressDTO addressDTO = addressService.findOne(id);
        if (addressDTO != null) {
            return ResponseEntity.ok(addressDTO);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public List<AddressDTO> getAllByAddressType(@PathVariable("type")AddressType type) {
        log.debug("REST request to get all Addresses by type: {}", type);
        return addressService.findAllByType(type);
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public List<AddressDTO> getAllByCompanyId(@PathVariable("id") Long id) {
        log.debug("REST request to get all Addresses by Company id :{}", id);
        return addressService.findAllByCompanyId(id);
    }

    @RequestMapping(value = "/company/{id}/type/{type}", method = RequestMethod.GET)
    public List<AddressDTO> getAllByCompanyIdAndAddressType(@PathVariable("id") Long id,
                                              @PathVariable("type")AddressType type) {
        log.debug("REST request to get all Addresses by Company id: {} and type: {}", id, type);
        return addressService.findAllByCompanyIdAndType(id, type);
    }

}
