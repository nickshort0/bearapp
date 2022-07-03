package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.security.CustomUserDetails;
import com.casestudy.bearapp.service.CustomUserDetailsService;
import com.casestudy.bearapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Slf4j
@Controller
@SessionAttributes(value = {"activeUser"})
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showIndex(Principal principal, HttpSession session){
        try{
            if(principal != null){
                session.setAttribute("activeUser", userService.getUserByUsername(principal.getName()));
                log.info("session ID: " + session.getId() + " activeUser: " + session.getAttribute("activeUser").toString());
            }

        }
        catch (Exception ex){
            log.warn("index exception");
            ex.printStackTrace();
        }
        return "index";
    }
}
