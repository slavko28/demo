package com.toptop.service;

import com.toptop.domain.User;
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
     * Find user by reset token.
     *
     * @param resetToken the token
     * @return the entity
     */
    Optional<User> getUserByResetToken(String resetToken);

    /**
     * Save user.
     *
     * @param user User to save
     */
    void saveUser(UserDTO user);

    /**
     * Update user.
     *
     * @param userDTO the user to update
     */
    void update(UserDTO userDTO);

    /**
     * Create reset token.
     *
     * @param user User to set reset token
     */
    String createResetToken(User user);

    /**
     * Reset User's password.
     *
     * @param user the user to password reset
     * @param password new password
     */
    void resetPassword(User user, String password);
}
