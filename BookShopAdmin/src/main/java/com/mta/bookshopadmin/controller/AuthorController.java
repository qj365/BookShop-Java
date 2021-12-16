package com.mta.bookshopadmin.controller;

import com.mta.bookshop.entity.Author;
import com.mta.bookshopadmin.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/author","/Author"})
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping({"/index", "/Index", ""})
    public String Index(Model model){
        List<Author> authorList = authorService.listAll();
        model.addAttribute("authorList", authorList);
        return "author/index";
    }

    @GetMapping({"/create","/Create"})
    public String Create(Model model){
        Author author = new Author();
        model.addAttribute("author",author);
        return "author/author-form";
    }

    @GetMapping({"edit/{id}","Edit/{id}"})
    public String Edit(@PathVariable(name = "id") Integer id, Model model){
        Author author = authorService.findById(id);
        model.addAttribute("author",author);
        return "author/author-form";

    }

    @PostMapping("/Save")
    public String Save(Author author){
        authorService.save(author);
        return "redirect:/Author";
    }

    @GetMapping({"delete/{id}","Delete/{id}"})
    public String Delete (@PathVariable(name = "id") Integer id){
        authorService.deleteById(id);
        return "redirect:/Author";

    }
}
