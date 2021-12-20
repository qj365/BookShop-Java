package com.mta.bookshopadmin.controller;

import com.mta.bookshopadmin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.mta.bookshop.entity.Category;

import java.util.List;

@Controller
@RequestMapping({"/category","/Category"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping({"/index", "/Index", ""})
    public String Index(Model model){
        List<Category> categoryList = categoryService.listAll();
        model.addAttribute("categoryList", categoryList);
        return "category/index";
    }

    @GetMapping({"/create","/Create"})
    public String Create(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "category/category-form";
    }

    @GetMapping({"edit/{id}","Edit/{id}"})
    public String Edit(@PathVariable(name = "id") Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/category-form";
    }

    @PostMapping("/Save")
    public String Save(Category category){
        categoryService.save(category);
        return "redirect:/Category";
    }

    @GetMapping({"delete/{id}","Delete/{id}"})
    public String Delete (@PathVariable(name = "id") Integer id){
        categoryService.deleteById(id);
        return "redirect:/Category";

    }
}
