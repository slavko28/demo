package com.toptop.service;

import com.toptop.service.dto.UserDTO;

import java.util.List;

/**
 * Service Interface for managing Address entities.
 */
public interface UserService {

    /**
     * Save new User.
     *
     * @param userDTO the address to save
     * @return the saved entity
     */
    UserDTO save(UserDTO userDTO);

    /**
     * Find user by Id.
     *
     * @param id the address id
     * @return the entity
     */
    UserDTO findOne(Long id);

    /**
     * Find all users.
     *
     * @return the list of entities
     */
    List<UserDTO> findAll();


}
