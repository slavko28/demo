package com.toptop.service;

import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.service.dto.UserDTO;

/**
 * Service Interface for managing Address entities.
 */
public interface UserService extends AbstractService<User, Long, UserDTO> {

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
