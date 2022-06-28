package com.casestudy.bearapp.controllers;

import com.casestudy.bearapp.models.Bear;
import com.casestudy.bearapp.service.BearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BearController {

    @Autowired
    private BearService bearService;


    //display list of bears
    @GetMapping("/bears")
    public String viewBearPage(Model model){
       return findPage(1, model);
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
    @GetMapping("/page/{pageNo}")
    public String findPage(@PathVariable(value = "pageNo") int pageNo, Model model){
        int pageSize = 5;
        Page<Bear> page = bearService.findPaginated(pageNo, pageSize);
        List<Bear> listBears = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listBears", listBears);
        return "bears";
    }

}
