package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
public class RegistrationController {
    UserService userService;
    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "registration_form";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/saveUser")
    public String saveUser(RedirectAttributes model, @ModelAttribute("user") User user){
        user.setRole("USER");
        log.info("User: " + user);
        userService.saveUser(user);
        model.addFlashAttribute("user", userService.getUserById(user.getId()));
        return "login";
    }

}
