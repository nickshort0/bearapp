package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.models.Weapon;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


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
        return findPage(1, "name", "asc", model);
    }


    @PostMapping("{id}/addWeaponToBear")
    public String addWeaponToBear(@RequestParam("weapon") String name, @PathVariable("id") long id, RedirectAttributes model){
        bearService.addWeapon(id, weaponService.getWeaponByName(name));
        return ("redirect:/");
    }

    @GetMapping("/weapons/page/{pageNo}")
    public String findPage(@PathVariable(value = "pageNo") int pageNo,
                           @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model){
        int pageSize = 5;
        Page<Weapon> page = weaponService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Weapon> listWeapons = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listWeapons", listWeapons);
        return "weapons";
    }
}
