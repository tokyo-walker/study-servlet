package com.example.demo.controller;

import com.example.demo.dto.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/items")
public class ShoppingCartController {

    @Autowired
    private ItemRepository repository;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        List<Item> list = repository.findAll();
        model.addAttribute("items", list);

        return "item-and-cart";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Long id,Model model) {
        repository.deleteById(id);

        return "item-and-cart";
    }



}
