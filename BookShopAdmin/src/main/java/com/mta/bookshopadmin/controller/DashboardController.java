package com.mta.bookshopadmin.controller;

import com.mta.bookshopadmin.service.BookService;
import com.mta.bookshopadmin.service.CustomerService;
import com.mta.bookshopadmin.service.OrderService;
import com.mta.bookshopadmin.dto.SoldBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping({"/dashboard","/Dashboard"})
@Controller
public class DashboardController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @GetMapping({"/index", "/Index", ""})
    public String Index(Model model){
        int newOrders = orderService.ordersListByIdState(1).size();
        int book = bookService.listAll().size();
        int customer = customerService.findAll().size();
        int cancelOrders = orderService.ordersListByIdState(3).size();
        int suscessOrders = orderService.ordersListByIdState(5).size();
        List<SoldBookInterface> soldBooks = orderService.topSoldBook();

        model.addAttribute("newOrders", newOrders);
        model.addAttribute("book", book);
        model.addAttribute("customer", customer);
        model.addAttribute("cancelOrders", cancelOrders);
        model.addAttribute("suscessOrders", suscessOrders);
        model.addAttribute("soldBooks", soldBooks);

        return "dashboard/index";
    }
}
