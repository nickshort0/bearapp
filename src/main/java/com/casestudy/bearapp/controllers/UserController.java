package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private UserService userService;
    private BearService bearService;

    @Autowired
    public UserController(UserService userService, BearService bearService) {
        this.userService = userService;
        this.bearService = bearService;
    }

    @GetMapping("/showAllUsers")
    public String viewHomePage(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/newUserForm")
    public String showNewUserForm(Model model){
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return ("new_user");
    }

    /*@PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return ("redirect:/");
    }*/

    @GetMapping("{userId}/addBear")
    public String addBearToUser(@RequestParam("bear") long bearId, @PathVariable("userId") long userId, RedirectAttributes model){
        userService.addBear(userId, bearService.getBearById(bearId));
        return ("redirect:/");
    }

}
