package com.toptop.service;

import com.toptop.domain.CurrentUser;
import com.toptop.domain.User;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

    User getCurrentUser();

}
