package com.toptop.service.impl;

import com.toptop.domain.CurrentUser;
import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.repository.UserRepository;
import com.toptop.service.CurrentUserService;
import com.toptop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOG = LoggerFactory.getLogger(CurrentUserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOG.debug("Checking if user={} has access to user={}", currentUser.getUsername(), userId);
        return currentUser.getRole() == UserRole.ADMIN || currentUser.getId().equals(userId);    }

    @Override
    public Optional<User> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LOG.debug("Find all order details by current manager: {}", auth.getName());
        return userRepository.findOneByEmail(auth.getName());
    }
}
