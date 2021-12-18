package com.mta.bookshopadmin.controller;

import com.mta.bookshop.entity.Author;
import com.mta.bookshop.entity.Book;
import com.mta.bookshop.entity.Category;
import com.mta.bookshop.entity.Publisher;
import com.mta.bookshopadmin.service.AuthorService;
import com.mta.bookshopadmin.service.BookService;
import com.mta.bookshopadmin.service.CategoryService;
import com.mta.bookshopadmin.service.PublisherService;

import com.mta.bookshopadmin.utility.FIleUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping({"/Book","/book"})
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;

    @GetMapping({"/index", "/Index", ""})
    public String Index(Model model, @Param("sa") Integer sa, @Param("sp") Integer sp, @Param("sc") Integer sc, @Param("mip") Integer mip, @Param("map") Integer map, @Param("sb") String sb){
        List<Book> bookList = new ArrayList<>();

        if (sa != null || sp != null || sc != null || mip != null || map != null || !StringUtils.isEmpty(sb)){
            bookList = bookService.filterBook(sa,sp,sc,map,mip,sb);
            model.addAttribute("sa", sa);
            model.addAttribute("sp", sp);
            model.addAttribute("sc", sc);
            model.addAttribute("map", map);
            model.addAttribute("mip", mip);
            model.addAttribute("sb", sb);

        }
        else
        {
            bookList = bookService.listAll();
        }


        List<Category> categoryList = categoryService.listAll();
        List<Publisher> publisherList = publisherService.listAll();
        List<Author> authorList = authorService.listAll();

        model.addAttribute("authorList",authorList);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("publisherList",publisherList);
        model.addAttribute("bookList", bookList);
        return "book/index";
    }

    @GetMapping({"/create","/Create"})
    public String Create(Model model){
        Book book = new Book();
        model.addAttribute("book",book);

        List<Category> categoryList = categoryService.listAll();
        List<Publisher> publisherList = publisherService.listAll();
        List<Author> authorList = authorService.listAll();

        model.addAttribute("authorList",authorList);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("publisherList",publisherList);
        return "book/book-form";
    }

    @GetMapping({"edit/{id}","Edit/{id}"})
    public String Edit(@PathVariable(name = "id") Integer id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);

        List<Category> categoryList = categoryService.listAll();
        List<Publisher> publisherList = publisherService.listAll();
        List<Author> authorList = authorService.listAll();

        model.addAttribute("authorList",authorList);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("publisherList",publisherList);
        return "book/book-form";

    }

    @PostMapping("/Save")
    public String Save(Book book, @RequestParam("exampleInputFile") MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            fileName = currentDate + fileName;
            book.setPhoto(fileName);

            String uploadDir = "./BookShopAdmin/src/main/resources/static/BookImage/";

            FIleUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        }
        else {
            if (book.getId() == 0)
                book.setPhoto("150x200.png");
            else
                book.setPhoto(bookService.findById(book.getId()).getPhoto());
        }

        bookService.save(book);

        return "redirect:/Book";
    }

    @GetMapping({"delete/{id}","Delete/{id}"})
    public String Delete (@PathVariable(name = "id") Integer id){
        bookService.deleteById(id);
        return "redirect:/Book";

    }
}
