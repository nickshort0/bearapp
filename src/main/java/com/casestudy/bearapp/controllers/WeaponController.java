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
    public String viewWeaponPage(Model model){
        return findPage(1, "name", "asc", model);
    }

    @GetMapping("/{bearId}/addWeapon")
    public String viewWeaponsToAdd(@PathVariable("bearId") long bearId, Model model){
        return findAddWeaponToBearPage(bearId,1, "name", "asc", model);
    }


    @GetMapping("{bearId}/addWeapon/{weaponId}")
    public String addWeaponToBear(@PathVariable("weaponId") long weaponId, @PathVariable("bearId") long bearId, RedirectAttributes model){
        bearService.addWeapon(bearId, weaponService.getWeaponById(weaponId));
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
    @GetMapping("/{bearId}/weapons/page/{pageNo}")
    public String findAddWeaponToBearPage(@PathVariable("bearId") long bearId,@PathVariable(value = "pageNo") int pageNo,
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
        model.addAttribute("bearId", bearId);
        model.addAttribute("listWeapons", listWeapons);
        return "add_weapon";
    }
}
