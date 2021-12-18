package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.Orders;
import com.mta.bookshopadmin.repository.OrderRepository;
import com.mta.bookshopadmin.dto.SoldBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
