package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.Category;
import com.mta.bookshopadmin.repository.AuthorRepository;
import com.mta.bookshopadmin.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAll(){
        return categoryRepository.findAll();
    }

    public void save(Category category){
        categoryRepository.save(category);
    }

    public Category findById(int id) {
        Optional<Category> result = categoryRepository.findById(id);

        Category category = null;

        if (result.isPresent()) {
            category = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find category id - " + id);
        }

        return category;
    }

    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
