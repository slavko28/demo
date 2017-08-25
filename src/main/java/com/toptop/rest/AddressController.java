package com.toptop.rest;

import com.toptop.domain.enums.AddressType;
import com.toptop.service.AddressService;
import com.toptop.service.dto.AddressDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final Logger log = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    public void create(@Validated @RequestBody AddressDTO addressDTO) {
        log.debug("REST request to save Address : {}", addressDTO);
        if (addressDTO.getId() == null) {
            addressService.save(addressDTO);
        }
    }

    @PutMapping("/address")
    public void update(@Validated @RequestBody AddressDTO addressDTO) {
        log.debug("REST request to update Address : {}", addressDTO);
        if (addressDTO.getId() != null) {
            addressService.save(addressDTO);
        }
    }

    @GetMapping("/addresses")
    public List<AddressDTO> getAll() {
        log.debug("REST request to get all Addresses");
        return addressService.findAll();
    }

    @GetMapping("/address/{id}")
    public AddressDTO getById(@PathVariable("id") Long id) {
        log.debug("REST request to get Address by id :{}", id);
        return addressService.findOne(id);
    }

    @GetMapping("/addresses/{type}")
    public List<AddressDTO> getAllByAddressType(@PathVariable("type")AddressType type) {
        log.debug("REST request to get all Addresses by type: {}", type);
        return addressService.findAllByType(type);
    }

    @GetMapping("/address/company/{id}")
    public List<AddressDTO> getAllByCompanyId(@PathVariable("id") Long id) {
        log.debug("REST request to get all Addresses by Company id :{}", id);
        return addressService.findAllByCompanyId(id);
    }

    @GetMapping("/address/company/{id}/{type}")
    public List<AddressDTO> getAllByCompanyIdAndAddressType(@PathVariable("id") Long id,
                                              @PathVariable("type")AddressType type) {
        log.debug("REST request to get all Addresses by Company id: {} and type: {}", id, type);
        return addressService.findAllByCompanyIdAndType(id, type);
    }

}
