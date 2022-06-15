package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.service.BearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BearController {

    @Autowired
    private BearService bearService;

    //display list of bears
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listBears", bearService.getAllBears());
        return "index";
    }

    @GetMapping("/newBearForm")
    public String showAddBearForm(Model model){
        //create model attribute to bind form data
        Bear bear = new Bear();
        model.addAttribute("bear", bear);
        return ("new_bear");
    }

    @PostMapping("/addBear")
    public String addBear(@ModelAttribute("bear") Bear bear){
        bearService.saveBear(bear);
        return ("redirect:/");
    }

}
