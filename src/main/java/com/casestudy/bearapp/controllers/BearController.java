package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BearController {

    private WeaponService weaponService;
    private BearService bearService;

    @Autowired
    public BearController(WeaponService weaponService, BearService bearService) {
        this.weaponService = weaponService;
        this.bearService = bearService;
    }

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

    @GetMapping("/addWeapon/{id}")
    public String showAddWeaponForm(@PathVariable long id, Model model){
        Weapon weapon  = new Weapon();
        model.addAttribute("bear", bearService.getBearById(id));
        //list of addable weapons
        List<Weapon> weaponsToAdd = weaponService.getAllWeapons();
        //TODO: getUserWeapons in service to remove from this list
        model.addAttribute("weaponsToAdd", weaponsToAdd);
        return ("add_weapon");
    }

}
