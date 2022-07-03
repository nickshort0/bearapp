package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.service.ArmorService;
import com.casestudy.bearapp.service.BearService;
import com.casestudy.bearapp.service.WeaponService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Controller
public class BearController {


    BearService bearService;
    WeaponService weaponService;
    ArmorService armorService;

    @Autowired
    public BearController(BearService bearService, WeaponService weaponService, ArmorService armorService) {
        this.bearService = bearService;
        this.weaponService = weaponService;
        this.armorService = armorService;
    }


    //display list of bears
    @GetMapping("/bears")
    public String viewBearPage(Model model){
       return findPage(1, "name", "asc", model);
    }

    @GetMapping("/newBearForm")
    public String showAddBearForm(Model model){
        //create model attribute to bind form data
        Bear bear = new Bear();
        model.addAttribute("bear", bear);
        return ("new_bear");
    }

    @PostMapping("/saveBear")
    public String saveBear(@ModelAttribute("bear") Bear bear){
        bearService.saveBear(bear);
        return ("redirect:/bears");
    }

    //pagination
    @GetMapping("/bears/page/{pageNo}")
    public String findPage(@PathVariable(value = "pageNo") int pageNo,
                           @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model){
        int pageSize = 5;
        Page<Bear> page = bearService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Bear> listBears = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listBears", listBears);
        return "bears";
    }


}
