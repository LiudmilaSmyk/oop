package org.example.controller;

import org.example.model.Laptop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LaptopController {

    private List<Laptop> laptops = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("laptops", laptops);
        model.addAttribute("newLaptop", new Laptop());
        return "index";
    }

    @PostMapping("/addLaptop")
    public String addLaptop(@ModelAttribute Laptop laptop, Model model) {
        laptops.add(laptop);
        model.addAttribute("laptops", laptops);
        model.addAttribute("newLaptop", new Laptop());
        return "index";
    }
}

