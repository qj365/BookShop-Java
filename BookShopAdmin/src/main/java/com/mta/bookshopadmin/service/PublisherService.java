package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.Publisher;
import com.mta.bookshopadmin.repository.AuthorRepository;
import com.mta.bookshopadmin.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> listAll(){
        return publisherRepository.findAll();
    }

    public void save(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public Publisher findById(int id) {
        Optional<Publisher> result = publisherRepository.findById(id);

        Publisher publisher = null;

        if (result.isPresent()) {
            publisher = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find publisher id - " + id);
        }

        return publisher;
    }

    public void deleteById(int id) {
        publisherRepository.deleteById(id);
    }
}
