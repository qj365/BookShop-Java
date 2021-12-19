package com.mta.bookshopadmin.controller;

import com.mta.bookshop.entity.Author;
import com.mta.bookshop.entity.Orders;
import com.mta.bookshopadmin.service.AuthorService;
import com.mta.bookshopadmin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Controller
@RequestMapping({"/order", "Order"})
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping({"/index", "/Index", ""})
    public String Index(Model model){
        List<Orders> ordersList = orderService.findAll();
        model.addAttribute("ordersList", ordersList);
        return "order/index";
    }

    @GetMapping({"Confirm/{id}","confirm/{id}"})
    public String Confirm(@PathVariable (name = "id") Integer id){
        Orders order = orderService.findById(id);
        if(order.getIdState() != 1)
            return "shared/_error";
        else {
            order.setIdState(2);
            orderService.save(order);
            return "redirect:/Order";
        }

    }

    @GetMapping({"Delivery/{id}","delivery/{id}"})
    public String Delivery(@PathVariable (name = "id") Integer id){
        Orders order = orderService.findById(id);
        if(order.getIdState() != 2)
            return "shared/_error";
        else {
            order.setIdState(4);
            orderService.save(order);
            return "redirect:/Order";
        }

    }

    @GetMapping({"Complete/{id}","complete/{id}"})
    public String Complete(@PathVariable (name = "id") Integer id){
        Orders order = orderService.findById(id);
        if(order.getIdState() != 4)
            return "shared/_error";
        else {
            order.setIdState(5);
            orderService.save(order);
            return "redirect:/Order";
        }

    }

    @PostMapping({"/Huy/{id}", "/huy/{id}"})
    public String Huy(@PathVariable (name = "id") Integer id, Model model, @Param("reason") String reason, @Param("other") String other) {
        Orders order = orderService.findById(id);
        if(order.getIdState() == 3 || order.getIdState() == 5)
            return "shared/_error";
        else {
            model.addAttribute("reason",reason);
            model.addAttribute("other",other);

            order.setIdState(3);
            if(!StringUtils.isEmpty(reason)){
                order.setReason(reason);
            }
            else
                order.setReason(other);
            order.setReason(order.getReason() + " | " +new Date());
            orderService.save(order);
            return "redirect:/Order";

        }
    }

    @GetMapping({"Info/{id}","info/{id}"})
    public String Info(@PathVariable (name = "id") Integer id, Model model){
        Orders order = orderService.findById(id);
        model.addAttribute("order",order);
        return "order/info";
    }


}
