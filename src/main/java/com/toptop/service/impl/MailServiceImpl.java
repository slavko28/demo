package com.toptop.service.impl;

import com.toptop.domain.User;
import com.toptop.service.MailService;
import com.toptop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MailServiceImpl implements MailService {

    private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);

    private final String FROM_MAIL = "support@tttrans.com";
    private final String PASSWORD_RESET_SUBJECT = "Password Reset Request";
    private final String TEXT_TO_PASSWORD_RESET_MAIL = "To reset your password, click the link below:\n" +
            "<a href=\"%s/reset/pass?token=%s\">Reset my password</a>";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Override
    public void sentMailToPasswordReset(HttpServletRequest url, User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        String token = userService.createResetToken(user);
        message.setFrom(FROM_MAIL);
        message.setTo(user.getEmail());
        message.setSubject(PASSWORD_RESET_SUBJECT);
        String link = url.getScheme() + "://" + url.getHeader("Host");
        message.setText(String.format(TEXT_TO_PASSWORD_RESET_MAIL, link, token));
        LOG.debug("Sending reset password message to email address: {} with path: {}, token: {} ", user.getEmail(), link, token);
        mailSender.send(message);
    }
}
