package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class ProductFormController {

    @GetMapping("/")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/saveProduct")
    public String displayProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("product", product);
        return "product-display";

    }
}
