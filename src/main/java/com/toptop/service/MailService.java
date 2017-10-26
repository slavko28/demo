package com.toptop.service;

import com.toptop.domain.User;

import javax.servlet.http.HttpServletRequest;

public interface MailService {

    void sentMailToPasswordReset(HttpServletRequest url, User user);
}
