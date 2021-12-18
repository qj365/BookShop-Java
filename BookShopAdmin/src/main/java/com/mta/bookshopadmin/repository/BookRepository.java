package com.mta.bookshopadmin.repository;

import com.mta.bookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book> findBookByIdAuthor(Integer id);
    public List<Book> findBookByIdPublisher(Integer id);
    public List<Book> findBookByIdCategory(Integer id);
    public List<Book> findBookByPriceGreaterThanEqual (Integer amount);
    public List<Book> findBookByPriceLessThanEqual (Integer amount);
    public List<Book> findBookByNameContains (String name);



}
