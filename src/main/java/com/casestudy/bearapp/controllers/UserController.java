package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class UserController {
    UserService userService;
    BearService bearService;

    @Autowired
    public UserController(UserService userService, BearService bearService) {
        this.userService = userService;
        this.bearService = bearService;
    }


    @GetMapping("/newUserForm")
    public String showNewUserForm(Model model){
        //create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return ("new_user");
    }

    @GetMapping("/user")
    public String userPage(){
        return "user_page";
    }

    @GetMapping("{userId}/addBear")
    public String addBearToUser(@RequestParam("bear") long bearId, @PathVariable("userId") long userId, RedirectAttributes model){
        userService.addBear(userId, bearService.getBearById(bearId));
        return ("redirect:/{userId}/myBears");
    }

    @GetMapping("{userId}/removeBear")
    public String removeBearFromUser(@RequestParam("bear") long bearId, @PathVariable("userId") long userId, RedirectAttributes model){
        bearService.removeArmor(bearId);
        bearService.removeWeapon(bearId);
        userService.removeBear(userId, bearService.getBearById(bearId));
        return ("redirect:/{userId}/myBears");
    }

    //display list of bears
    @GetMapping("{userId}/myBears")
    public String viewUserBearPage(@PathVariable("userId") long userId, Model model){
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user_bears";
    }

}
