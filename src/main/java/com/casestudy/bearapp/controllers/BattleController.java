package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.User;
import com.casestudy.bearapp.service.BattleService;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BattleController {
    BattleService battleService;
    UserService userService;
    BearService bearService;
    @Autowired
    public BattleController(BattleService battleService, UserService userService, BearService bearService) {
        this.battleService = battleService;
        this.userService = userService;
        this.bearService = bearService;
    }

    @GetMapping("/battle/{bear1}/{bear2}")
    public String viewBattlePage(){

        return "battle_form";
    }

    @PostMapping("/battleResults")
    public String battle(@RequestParam("bear1") long id1, @RequestParam("bear2") long id2, RedirectAttributes model){

        return ("battle");
    }

    @GetMapping("{userId}/battle")
    public String viewUserBearPage(@PathVariable("userId") long userId, Model model){
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "battle";
    }

}
