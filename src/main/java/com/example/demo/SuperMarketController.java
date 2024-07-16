package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SuperMarketController {
	
	private SuperMarketService service;

	public SuperMarketController(SuperMarketService service) {
		super();
		this.service = service;
	}
	@GetMapping("/")
    public String listItems(Model model) {
        List<SuperMarket> items = service.getAllItems();
        model.addAttribute("list_of_items", items);
        return "index";
    }
	
	@GetMapping("/deleteitem/{id}")
	public String deleteItem(@PathVariable int id) {
		service.deleteItem(id);
		return "redirect:/";
	}
	@GetMapping("/additem")
	public String CreateItem(Model model) {
		SuperMarket sm= new SuperMarket();
		model.addAttribute("item",sm);
		return "additem";
	}
	@GetMapping("/updateItem/{Id}")
	public String newStudent(@PathVariable int id, Model model) {
		SuperMarket sm= new SuperMarket();
		model.addAttribute("item",sm);
		return "additem";
	}
	
	@PostMapping("/save")
	public String createItem(@ModelAttribute SuperMarket sm) {
		service.saveItem(sm);
		return "redirect:/";
	}
	
	
	
}
