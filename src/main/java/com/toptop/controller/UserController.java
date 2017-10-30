package com.toptop.controller;

import com.toptop.service.UserService;
import com.toptop.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.NoSuchElementException;

@Controller
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Value("${spring.messages.user-create-success}")
    private String createSuccess;

    @Value("${spring.messages.user-create-error}")
    private String createError;

    @Autowired
    private UserService userService;

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOG.debug("Getting user page for user={}", id);
        UserDTO userDTO = userService.findOne(id);
        if (userDTO == null) {
            throw new NoSuchElementException(String.format("User=%s not found", id));
        }
        return new ModelAndView("admin/user", "user", userDTO);
    }

    @RequestMapping(value = "/user/create")
    public ModelAndView getUserCreatePage() {
        LOG.debug("Getting user create form");
        return new ModelAndView("user_create", "user", new UserDTO());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ModelAndView handleUserCreateForm(@ModelAttribute UserDTO userDTO,
                                             RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("user_create");
        LOG.debug("Processing user create form={}", userDTO);
        if (userService.getUserByEmail(userDTO.getEmail()).isPresent()) {
            LOG.warn("User with email {} is already exist", userDTO.getEmail());
            modelAndView.addObject("error", String.format(createError, userDTO.getEmail()));
            return modelAndView;
        }
        userService.saveUser(userDTO);
        redirectAttributes.addFlashAttribute("successMessage", createSuccess);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute UserDTO userDTO) {
        LOG.debug("Updating user's data. ID: {}", userDTO.getId());
        userService.update(userDTO);
        return "redirect:/admin/user/all";
    }

    @RequestMapping("/admin/user/all")
    public ModelAndView getUsersPage() {
        LOG.debug("Getting users page");
        return new ModelAndView("admin/user_all", "users", userService.findAll());
    }

}
