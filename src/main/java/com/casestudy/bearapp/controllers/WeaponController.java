package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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



    @PostMapping("{id}/addWeaponToBear")
    public String addWeaponToBear(@RequestParam("weapon") String name, @PathVariable("id") long id, RedirectAttributes model){
        bearService.addWeapon(id, weaponService.getWeaponByName(name));
        return ("redirect:/");
    }
}
