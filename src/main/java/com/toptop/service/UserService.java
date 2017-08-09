package com.toptop.service;

import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.service.dto.UserDTO;

import java.util.List;

/**
 * Service Interface for managing Address entities.
 */
public interface UserService {

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

    /**
     * Find user by email.
     *
     * @param email the email
     * @return the entity
     */
    User findUserByEmail(String email);

    /**
     * Save user with role.
     *
     * @param user user to save
     * @param role user role
     */
    void saveUserWithRole(UserDTO user, UserRole role);


}
