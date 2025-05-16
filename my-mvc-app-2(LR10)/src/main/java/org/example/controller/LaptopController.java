package org.example.controller;

import org.example.model.Laptop;
import org.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LaptopController {

    @Autowired
    private LaptopRepository laptopRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("laptops", laptopRepository.findAll());
        model.addAttribute("newLaptop", new Laptop());
        return "index";
    }

    @PostMapping("/addLaptop")
    public String addLaptop(@ModelAttribute Laptop laptop) {
        laptopRepository.save(laptop);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid laptop Id:" + id));
        model.addAttribute("laptop", laptop);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateLaptop(@PathVariable Long id, @ModelAttribute Laptop laptop) {
        laptop.setId(id);
        laptopRepository.save(laptop);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteLaptop(@PathVariable Long id) {
        laptopRepository.deleteById(id);
        return "redirect:/";
    }
}

