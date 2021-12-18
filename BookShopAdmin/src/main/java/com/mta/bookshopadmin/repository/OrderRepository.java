package com.mta.bookshopadmin.repository;

import com.mta.bookshop.entity.Orders;
import com.mta.bookshopadmin.dto.SoldBookInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
    public List<Orders> findByIdState(int id);
    @Query(value = "select sum(b.Amount) from DetailOrder b, Orders a WHERE IdOrder = a.Id AND a.IdState != 3 and IdBook = ?1", nativeQuery = true)
    public int soldBookAmount (int idBook);

    @Query(value = "select top 5 idbook as IdBook, Book.Name as Name, sum(DetailOrder.Amount) as Amount \n" +
            "from DetailOrder, Orders, Book \n" +
            "WHERE IdOrder = orders.Id AND ORDERS.IdState != 3 and IdBook = Book.Id \n" +
            "group by IdBook, Book.Name \n" +
            "order by Amount DESC;", nativeQuery = true)
    public List<SoldBookInterface> topSoldBook();
}
