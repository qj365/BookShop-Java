package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.Author;
import com.mta.bookshop.entity.Orders;
import com.mta.bookshopadmin.repository.OrderRepository;
import com.mta.bookshopadmin.dto.SoldBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> ordersListByIdState(int id){
        return orderRepository.findByIdState(id);
    }

    public int soldBookAmount(int idBook){
        return orderRepository.soldBookAmount(idBook);
    }

    public List<SoldBookInterface> topSoldBook(){
        return orderRepository.topSoldBook();
    }

    public  List<Orders> findAll(){
        return orderRepository.findAllByOrderByIdStateAsc();
    }

    public Orders findById(int id) {
        Optional<Orders> result = orderRepository.findById(id);

        Orders order = null;

        if (result.isPresent()) {
            order = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find order id - " + id);
        }

        return order;
    }
    public void save(Orders order){
        orderRepository.save(order);
    }

}
