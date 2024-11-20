package com.iuh.se.controller;

import com.iuh.se.entities.DienThoai;
import com.iuh.se.service.DienThoaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class DienThoaiController {
    @Autowired
    private DienThoaiService dienThoaiService;

    @GetMapping("/")
    public String gelAll(Model model){
        model.addAttribute("dienthoais", dienThoaiService.getAll());
        return "index";
    }

    @GetMapping("/show_add_form")
    public String showAddForm(Model model){
        model.addAttribute("dienthoai", new DienThoai());
        return "add-form";
    }

    @PostMapping("/process_add")
    public String processAdd(@Valid @ModelAttribute("dienthoai") DienThoai dienThoai, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-form";
        }
        dienThoaiService.add(dienThoai);
        return "redirect:/";
    }

    @GetMapping("/show_update_form")
    public String showUpdateForm(@RequestParam("id") int maDienThoai, Model model){
        model.addAttribute("dienthoai", dienThoaiService.getById(maDienThoai));
        return "update-form";
    }

    @PostMapping("/process_update")
    public String processUpdate(@Valid @ModelAttribute("dienthoai") DienThoai dienThoai, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "update-form";
        }
        dienThoaiService.update(dienThoai);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int maDienThoai){
        dienThoaiService.delete(maDienThoai);
        return "redirect:/";
    }

}
