package com.mta.bookshopadmin.controller;
import com.mta.bookshop.entity.Publisher;
import com.mta.bookshopadmin.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/publisher","/Publisher"})
public class PublisherController {
    @Autowired
    private PublisherService publisherService;


    @GetMapping({"/index", "/Index", ""})
    public String Index(Model model){
        List<Publisher> publisherList = publisherService.listAll();
        model.addAttribute("publisherList", publisherList);
        return "publisher/index";
    }

    @GetMapping({"/create","/Create"})
    public String Create(Model model){
        Publisher publisher = new Publisher();
        model.addAttribute("publisher",publisher);
        return "publisher/publisher-form";
    }

    @GetMapping({"edit/{id}","Edit/{id}"})
    public String Edit(@PathVariable(name = "id") Integer id, Model model){
        Publisher publisher = publisherService.findById(id);
        model.addAttribute("publisher",publisher);
        return "publisher/publisher-form";
    }

    @PostMapping("/Save")
    public String Save(Publisher publisher){
        publisherService.save(publisher);
        return "redirect:/Publisher";
    }

    @GetMapping({"delete/{id}","Delete/{id}"})
    public String Delete (@PathVariable(name = "id") Integer id){
        publisherService.deleteById(id);
        return "redirect:/Publisher";

    }
}

