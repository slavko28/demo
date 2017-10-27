package com.toptop.service.impl;

import com.toptop.domain.User;
import com.toptop.service.MailService;
import com.toptop.service.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);

    @Value("${spring.messages.from-email}")
    private String fromEmail;

    @Value("${spring.messages.password-reset-subject}")
    private String passwordResetSubject;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private Configuration freemarkerConfiguration;

    @Override
    public void sentMailToPasswordReset(HttpServletRequest url, User user) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String token = userService.createResetToken(user);
        helper.setFrom(fromEmail);
        helper.setTo(user.getEmail());
        helper.setSubject(passwordResetSubject);
        String link = url.getScheme() + "://" + url.getHeader("Host");
        Template template = getTemplate();
        Map<String, Object> model = new HashMap<>();
        model.put("link", link);
        model.put("token", token);
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        helper.setText(text, true);
        LOG.debug("Sending reset password message to email address: {} with path: {}, token: {} ", user.getEmail(), link, token);
        mailSender.send(message);
    }

    private Template getTemplate() throws IOException {
        freemarkerConfiguration.setClassForTemplateLoading(this.getClass(), "/templates");
        return freemarkerConfiguration.getTemplate("email.ftl");
    }
}
