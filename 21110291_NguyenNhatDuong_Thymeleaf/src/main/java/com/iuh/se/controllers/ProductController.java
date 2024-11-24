package com.iuh.se.controllers;

import com.iuh.se.entities.Product;
import com.iuh.se.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "index";
    }

    @GetMapping("/details")
    public String details() {
        return "details";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "add-form";
    }

    @PostMapping("/add")
    public String add(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        Product product = productService.getAll().stream().filter(p -> p.getId() == id).findFirst().get();
        productService.delete(product);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable("id") int id, Model model) {
        Product product = productService.getAll().stream().filter(p -> p.getId() == id).findFirst().get();
        model.addAttribute("product", product);
        return "update-form";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("products", productService.getAll().stream().filter(p -> p.getName().contains(name)).toList());
        return "index";
    }

    @GetMapping("/sort")
    public String sort(@RequestParam("type") String type, Model model) {
        model.addAttribute("products", productService.getAll().stream().sorted((p1, p2) -> {
            if (type.equals("asc")) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p2.getName().compareTo(p1.getName());
            }
        }).toList());
        return "index";
    }

}
