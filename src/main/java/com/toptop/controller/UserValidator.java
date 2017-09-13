package com.toptop.controller;

import com.toptop.service.UserService;
import com.toptop.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    private static final Logger LOG = LoggerFactory.getLogger(UserValidator.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOG.debug("Validating {}", target);
        UserDTO userDTO = (UserDTO) target;
        validatePasswords(errors, userDTO);
        validateEmail(errors, userDTO);
    }

    private void validatePasswords(Errors errors, UserDTO userDTO) {
        if (!userDTO.getPassword().equals(userDTO.getPasswordRepeated())) {
            errors.reject("password.no_match", "Passwords do not match");
        }
    }

    private void validateEmail(Errors errors, UserDTO userDTO) {
        if (userService.getUserByEmail(userDTO.getEmail()) != null) {
            errors.reject("email.exists", "User with this email already exists");
        }
    }
}
