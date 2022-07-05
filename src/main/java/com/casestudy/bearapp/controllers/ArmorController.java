package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Armor;
import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.service.ArmorService;
import com.casestudy.bearapp.service.BearService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class ArmorController {
    private ArmorService armorService;
    private BearService bearService;

    @Autowired
    public ArmorController(ArmorService armorService, BearService bearService) {
        this.armorService = armorService;
        this.bearService = bearService;
    }

    //display list of armor
    @GetMapping("/armor")
    public String viewHomePage(Model model){
        return findPage(1, "name", "asc", model);
    }


    @GetMapping("/{bearId}/addArmor")
    public String viewArmorToAdd(@PathVariable("bearId") long bearId, Model model){
        return findAddArmorToBearPage(bearId,1, "name", "asc", model);
    }


    @GetMapping("{userId}/{bearId}/addArmor/{armorId}")
    public String addArmorToBear(@PathVariable("armorId") long armorId, @PathVariable("bearId") long bearId, RedirectAttributes model){
        bearService.addArmor(bearId, armorService.getArmorById(armorId));
        log.info("armor id " + armorId + "added to bear id: " + bearId);
        return ("redirect:/{userId}/myBears");
    }

    @GetMapping("{userId}/{bearId}/removeArmor")
    public String removeArmorFromBear(@PathVariable("bearId") long bearId, RedirectAttributes model){
        bearService.removeArmor(bearId);
        log.info("armor removed from bear id: " + bearId);
        return ("redirect:/{userId}/myBears");
    }

    @GetMapping("/armor/page/{pageNo}")
    public String findPage(@PathVariable(value = "pageNo") int pageNo,
                           @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model){
        int pageSize = 7;
        Page<Armor> page = armorService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Armor> listArmor = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listArmor", listArmor);
        return "armor";
    }

    @GetMapping("/{bearId}/armor/page/{pageNo}")
    public String findAddArmorToBearPage(@PathVariable("bearId") long bearId,@PathVariable(value = "pageNo") int pageNo,
                                          @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model){
        int pageSize = 5;
        Page<Armor> page = armorService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Armor> listArmor = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("bearId", bearId);
        Bear bear = bearService.getBearById(bearId);
        model.addAttribute(bear);
        model.addAttribute("listArmor", listArmor);
        return "add_armor";
    }


}
