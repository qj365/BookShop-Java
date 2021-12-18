package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.Author;
import com.mta.bookshop.entity.Book;
import com.mta.bookshopadmin.repository.AuthorRepository;
import com.mta.bookshopadmin.repository.BookRepository;
import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listAll(){
        return bookRepository.findAll();
    }

    public void save(Book book){
        bookRepository.save(book);
    }

    public Book findById(int id) {
        Optional<Book> result = bookRepository.findById(id);

        Book book = null;

        if (result.isPresent()) {
            book = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find book id - " + id);
        }

        return book;
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> filterBook(Integer idAuthor, Integer idPublisher, Integer idCategory, Integer greater, Integer less, String name){
        List<List<Book>> containList = new ArrayList<>();
        if (idAuthor != null){
            List<Book> listAuthor = bookRepository.findBookByIdAuthor(idAuthor);
            containList.add(listAuthor);
        }
        if (idCategory != null){
            List<Book> listCate = bookRepository.findBookByIdCategory(idCategory);
            containList.add(listCate);
        }
        if (idPublisher != null){
            List<Book> listPub = bookRepository.findBookByIdPublisher(idPublisher);
            containList.add(listPub);
        }
        if (greater != null){
            List<Book> listGreater = bookRepository.findBookByPriceGreaterThanEqual(greater);
            containList.add(listGreater);
        }
        if (less != null){
            List<Book> listLess = bookRepository.findBookByPriceLessThanEqual(less);
            containList.add(listLess);
        }
        if (!StringUtils.isEmpty(name)){
            List<Book> listName = bookRepository.findBookByNameContains(name);
            containList.add(listName);
        }

        HashSet<Book> intersectionSet = new HashSet<>(containList.get(0));
        for (int i = 1; i < containList.size(); i++)
        {
            HashSet<Book> set = new HashSet<>(containList.get(i));

            intersectionSet.retainAll(set);
        }

        return new ArrayList<>(intersectionSet);
    }
}
