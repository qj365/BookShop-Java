package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.Author;
import com.mta.bookshopadmin.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> listAll(){
        return authorRepository.findAll();
    }

    public void save(Author author){
        authorRepository.save(author);
    }

    public Author findById(int id) {
        Optional<Author> result = authorRepository.findById(id);

        Author author = null;

        if (result.isPresent()) {
            author = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return author;
    }

    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

}
