package com.toptop.rest;

import com.toptop.domain.enums.AddressType;
import com.toptop.service.AddressService;
import com.toptop.service.dto.AddressDTO;
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
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final Logger log = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    /**
     * POST / : Create new Address
     *
     * @param addressDTO the Address to create
     * @return the ResponseEntity with status 201 ("Created") and redirect to "/api/address/all",
     * or with status 400 ("Bad Request") if the addressDTO is not valid,
     * or with status 409 ("Conflict") if the address has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody AddressDTO addressDTO) throws URISyntaxException {
        log.debug("request to save Address : {}", addressDTO);
        if (addressDTO.getId() == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(new URI("/api/address/all"));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Address with ID:" + addressDTO.getId() + " is already exists.", HttpStatus.CONFLICT);
    }

    /**
     * PUT / : Updates an existing address
     *
     * @param addressDTO the address DTO to update
     * @return the ResponseEntity with status 200 (Ok) and with body the updated addressDTO,
     * or with status 400 (Bad Request) if the addressDTO is not valid,
     * or with status 404 (Not Found) if the address couldn't be found
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @RequestBody AddressDTO addressDTO) {
        log.debug("REST request to update Address : {}", addressDTO);
        if (addressService.isExist(addressDTO)) {
            return ResponseEntity.ok(addressService.save(addressDTO));
        }
        log.debug("address: {} does not found.", addressDTO);
        return new ResponseEntity<>("address: " + addressDTO + " - does not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * GET /all : get all addresses.
     *
     * @return the ResponseEntity with status 200 (Ok) and with body the list of AddressDTO,
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        log.debug("request to get all Addresses");
        List<AddressDTO> list = addressService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * GET /:id : get address by ID.
     *
     * @param id the address ID
     * @return the ResponseEntity with status 200 (Ok) and with body the addressDTO,
     * or with status 404 (Not Found) if the address couldn't be found
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {
        log.debug("request to get Address by id :{}", id);
        AddressDTO addressDTO = addressService.findOne(id);
        if (addressDTO != null) {
            return ResponseEntity.ok(addressDTO);
        }
        log.debug("address with ID: {} does not found.", id);
        return new ResponseEntity<>("address with ID: " + id + " - does not found.", HttpStatus.NOT_FOUND);    }

    /**
     * GET /type/:type : get all addresses by type.
     *
     * @param type the requested Address type
     * @return the ResponseEntity with status 200 (Ok) and with body the list of AddressDTO,
     */
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByAddressType(@PathVariable("type") AddressType type) {
        log.debug("request to get all Addresses by type: {}", type);
        return ResponseEntity.ok(addressService.findAllByType(type));
    }

    /**
     * GET /company/:id : get all addresses by company ID.
     *
     * @param id the Company ID
     * @return the ResponseEntity with status 200 (Ok) and with body the list of AddressDTO,
     */
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyId(@PathVariable("id") Long id) {
        log.debug("request to get all Addresses by Company id :{}", id);
        return ResponseEntity.ok(addressService.findAllByCompanyId(id));
    }

    /**
     * GET /company/:id/type/:type : get all addresses by company ID and address type.
     *
     * @param id the Company ID
     * @param type the Address type
     * @return the ResponseEntity with status 200 (Ok) and with body the list of AddressDTO,
     */
    @RequestMapping(value = "/company/{id}/type/{type}", method = RequestMethod.GET)
    public ResponseEntity getAllByCompanyIdAndAddressType(@PathVariable("id") Long id,
                                                          @PathVariable("type")AddressType type) {
        log.debug("request to get all Addresses by Company id: {} and type: {}", id, type);
        return ResponseEntity.ok(addressService.findAllByCompanyIdAndType(id, type));
    }

}
