package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuperMarketController {
    
    private final SuperMarketService service;
    private final RackService rackserv;
    private final ShelfService shelfservice;
    
    @Autowired
    public SuperMarketController(SuperMarketService service, RackService rackserv, ShelfService shelfservice) {
        this.service = service;
        this.rackserv = rackserv;
        this.shelfservice = shelfservice;
    }
    
    @GetMapping("/")
    public String listItems(Model model) {
        List<SuperMarket> items = service.getAllItems();
        model.addAttribute("list_of_items", items);
        return "index";
    }

   
    @GetMapping("/deleteitem/{id}")
    public String deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return "redirect:/";
    }

    @GetMapping("/additem")
    public String createItem(Model model) {
        SuperMarket sm = new SuperMarket();
        model.addAttribute("item", sm);
        return "additem";
    }

    @GetMapping("/updateitem/{id}")
    public String updateItem(@PathVariable Long id, Model model) {
        SuperMarket sm = service.findById(id);
        if (sm != null) {
            model.addAttribute("item", sm);
            return "additem";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/save")
    public String saveItem(@ModelAttribute SuperMarket sm) {
        service.saveItem(sm);
        return "redirect:/";
    }

    @GetMapping("/layout")
    public String getLayout(Model model) {
        model.addAttribute("racks", rackserv.getAllRacks());
        return "supermarket";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam Long shelfId, @RequestParam String itemName, @RequestParam Double itemPrice) {
        Shelf shelf = shelfservice.findById(shelfId);
        if (shelf != null && shelf.getItem() == null) {
            SuperMarket item = new SuperMarket();
            item.setName(itemName);
            item.setPrice(itemPrice);
            item.setShelf(shelf);
            service.saveItem(item);
        } else {
            // Handle case where shelf is already occupied
        }
        return "redirect:/layout";
    }

    @GetMapping("/newitem")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new SuperMarket());
        model.addAttribute("list_of_racks", rackserv.getAllRacks());
        model.addAttribute("list_of_shelves", shelfservice.findAll());
        return "additem";  // Assumes you have a Thymeleaf template named "additem.html"
    }
}
