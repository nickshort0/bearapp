package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.service.ArmorService;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class ArmorController {
    private ArmorService armorService;
    private BearService bearService;

    @Autowired
    public ArmorController(ArmorService armorService, BearService bearService) {
        this.armorService = armorService;
        this.bearService = bearService;
    }

    //display list of weapons
    @GetMapping("/armor")
    public String viewHomePage(Model model){
        model.addAttribute("listArmor", armorService.getAllArmors());
        return "view_armor";
    }



    @PostMapping("{id}/addArmorToBear")
    public String addWeaponToBear(@RequestParam("armor") String name, @PathVariable("id") long id, RedirectAttributes model){
        bearService.addArmor(id, armorService.getArmorByName(name));
        return ("redirect:/");
    }
}
