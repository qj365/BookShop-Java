package com.mta.bookshopadmin.controller;

import com.mta.bookshop.entity.Customer;
import com.mta.bookshopadmin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/customer","/Customer"})
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping({"/index", "/Index", ""})
    public String Index(Model model){
        List<Customer> customerList = customerService.listAll();
        model.addAttribute("customerList", customerList);
        return "customer/index";
    }

    @GetMapping({"/create","/Create"})
    public String Create(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer/customer-form";
    }

    @GetMapping({"edit/{id}","Edit/{id}"})
    public String Edit(@PathVariable(name = "id") Integer id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "customer/customer-form";
    }

    @PostMapping("/Save")
    public String Save(Customer customer){
        customerService.save(customer);
        return "redirect:/Customer";
    }

    @GetMapping({"delete/{id}","Delete/{id}"})
    public String Delete (@PathVariable(name = "id") Integer id){
        customerService.deleteById(id);
        return "redirect:/Customer";

    }
}

