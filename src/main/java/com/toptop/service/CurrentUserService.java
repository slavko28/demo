package com.toptop.service;

import com.toptop.domain.CurrentUser;
import com.toptop.domain.User;

import java.util.Optional;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

    Optional<User> getCurrentUser();

}
