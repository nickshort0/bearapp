package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.service.BattleService;
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

    @Autowired
    BattleService battleService;
    @GetMapping("/battle")
    public String viewBattlePage(){

        return "battle_form";
    }

    @PostMapping("/battleResults")
    public String battle(@RequestParam("bear1") long id1, @RequestParam("bear2") long id2, RedirectAttributes model){

        return ("battle");
    }

}
