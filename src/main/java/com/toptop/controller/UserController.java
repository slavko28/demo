package com.toptop.controller;

import com.toptop.service.UserService;
import com.toptop.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        log.debug("Getting user page for user={}", id);
        UserDTO userDTO = userService.findOne(id);
        if (userDTO == null) {
            throw new NoSuchElementException(String.format("User=%s not found", id));
        }
        return new ModelAndView("admin/user", "user", userDTO);
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        log.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserDTO());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserDTO userDTO, BindingResult bindingResult) {
        log.debug("Processing user create form={}, bindingResult={}", userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user_create";
        }
        try {
            userService.saveUser(userDTO);
        } catch (DataIntegrityViolationException e) {
            log.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
            bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute UserDTO userDTO) {
        log.debug("Updating user's data. ID: {}", userDTO.getId());
        userService.update(userDTO);
        return "redirect:/admin/user/all";
    }

    @RequestMapping("/admin/user/all")
    public ModelAndView getUsersPage() {
        log.debug("Getting users page");
        return new ModelAndView("admin/user_all", "users", userService.findAll());
    }

}
