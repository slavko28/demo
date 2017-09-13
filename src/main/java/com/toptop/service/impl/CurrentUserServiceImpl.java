package com.toptop.service.impl;

import com.toptop.domain.CurrentUser;
import com.toptop.domain.User;
import com.toptop.domain.enums.UserRole;
import com.toptop.repository.UserRepository;
import com.toptop.service.CurrentUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private final Logger log = LoggerFactory.getLogger(CurrentUserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        log.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == UserRole.ADMIN || currentUser.getId().equals(userId));    }

    @Override
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.debug("Find all order details by current manager: {}", auth.getName());
        return userRepository.findOneByEmail(auth.getName());
    }
}
