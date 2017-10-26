package com.toptop.controller;

import com.toptop.domain.User;
import com.toptop.service.MailService;
import com.toptop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ModelAndView getPasswordResetPage(@RequestParam Optional<String> error) {
        LOG.debug("Getting reset password page error={}", error);
        return new ModelAndView("password-reset", "error", error);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ModelAndView resetPasswordByEmail(ModelAndView modelAndView, HttpServletRequest request, @RequestParam("email") String email) {
        Optional<User> maybeUser = userService.getUserByEmail(email);
        if (!maybeUser.isPresent()) {
            LOG.debug("User with this email address {} wasn't found.", email);
            modelAndView.addObject("errorMessage", "User with this email address " + email + " wasn't found.");
        } else {
            mailService.sentMailToPasswordReset(request, maybeUser.get());
            modelAndView.addObject("successMessage", "A password reset link has been sent to " + email);
        }
        modelAndView.setViewName("password-reset");
        return modelAndView;
    }

    @RequestMapping(value = "/reset/pass", method = RequestMethod.GET)
    public ModelAndView getResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
        Optional<User> maybeUser = userService.getUserByResetToken(token);
        if (maybeUser.isPresent()) {
            modelAndView.addObject("token", token);
        } else {
            modelAndView.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
        }
        modelAndView.setViewName("new-password");
        return modelAndView;
    }

    @RequestMapping(value = "/reset/pass", method = RequestMethod.POST)
    public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
        Optional<User> maybeUser = userService.getUserByResetToken(requestParams.get("token"));
        maybeUser.ifPresent(user -> userService.resetPassword(user, requestParams.get("password")));
        redir.addFlashAttribute("successMessage", "You have successfully reset your password.  You may now login.");
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

}
