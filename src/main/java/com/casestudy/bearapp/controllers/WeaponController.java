package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class WeaponController {
    private WeaponService weaponService;
    private BearService bearService;

    @Autowired
    public WeaponController(WeaponService weaponService, BearService bearService) {
        this.weaponService = weaponService;
        this.bearService = bearService;
    }

    //display list of weapons
    @GetMapping("/weapons")
    public String viewHomePage(Model model){
        model.addAttribute("listWeapons", weaponService.getAllWeapons());
        return "view_weapons";
    }



    @PostMapping("/addWeaponSuccess")
    public String addWeapon(@ModelAttribute("weapon") Weapon weapon){
        weaponService.saveWeapon(weapon);
        return ("redirect:/");
    }
}
