package com.toptop.service;

import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.service.dto.UserDTO;

import java.util.Optional;

/**
 * Service Interface for managing User entities.
 */
public interface UserService extends AbstractService<User, Long, UserDTO> {

    /**
     * Find user by email.
     *
     * @param email the email
     * @return the entity
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Save user.
     *
     * @param user user to save
     */
    void saveUser(UserDTO user);

    void update(UserDTO userDTO);

}
