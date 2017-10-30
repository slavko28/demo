package com.toptop.controller;

import com.toptop.domain.User;
import com.toptop.service.MailService;
import com.toptop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@Controller
public class PasswordResetController {

    private final Logger LOG = LoggerFactory.getLogger(PasswordResetController.class);

    @Value("${spring.messages.password-reset-no_user}")
    private String userNotFound;

    @Value("${spring.messages.password-reset-token-sent}")
    private String tokenSent;

    @Value("${spring.messages.password-reset-token-invalid}")
    private String tokenInvalid;

    @Value("${spring.messages.password-reset-success}")
    private String resetSuccess;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ModelAndView getPasswordResetPage() {
        LOG.debug("Getting reset password page");
        return new ModelAndView("password-reset");
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ModelAndView resetPasswordByEmail(ModelAndView modelAndView, HttpServletRequest request, @RequestParam("email") String email) throws Exception {
        Optional<User> maybeUser = userService.getUserByEmail(email);
        if (!maybeUser.isPresent()) {
            LOG.debug("User with this email address {} wasn't found.", email);
            modelAndView.addObject("errorMessage", String.format(userNotFound, email));
        } else {
            mailService.sentMailToPasswordReset(request, maybeUser.get());
            modelAndView.addObject("successMessage", String.format(tokenSent, email));
        }
        modelAndView.setViewName("password-reset");
        return modelAndView;
    }

    @RequestMapping(value = "/reset/pass", method = RequestMethod.GET)
    public ModelAndView getNewPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
        LOG.debug("Getting page for creating new password");
        if (userService.checkToken(token)) {
            modelAndView.addObject("token", token);
        } else {
            modelAndView.addObject("errorMessage", tokenInvalid);
        }
        modelAndView.setViewName("new-password");
        return modelAndView;
    }

    @RequestMapping(value = "/reset/pass", method = RequestMethod.POST)
    public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
        Optional<User> maybeUser = userService.getUserByResetToken(requestParams.get("token"));
        maybeUser.ifPresent(user -> userService.resetPassword(user, requestParams.get("password")));
        redir.addFlashAttribute("successMessage", resetSuccess);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

}
