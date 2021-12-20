package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.Customer;
import com.mta.bookshopadmin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public List<Customer> listAll(){
        return customerRepository.findAll();
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findById(int id) {
        Optional<Customer> result = customerRepository.findById(id);

        Customer customer = null;

        if (result.isPresent()) {
            customer = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find customer id - " + id);
        }

        return customer;
    }

    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }


}
