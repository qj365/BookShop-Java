package com.mta.bookshop.entity;

import javax.persistence.*;

@Entity
@IdClass(DetailOrderPK.class)
public class DetailOrder {
    private int idOrder;
    private int idBook;
    private Integer amount;
    private Integer price;
    private Integer totalPrice;
    private Orders ordersByIdOrder;
    private Book bookByIdBook;

    @Id
    @Column(name = "IdOrder")
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Id
    @Column(name = "IdBook")
    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    @Basic
    @Column(name = "Amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "TotalPrice")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailOrder that = (DetailOrder) o;

        if (idOrder != that.idOrder) return false;
        if (idBook != that.idBook) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + idBook;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdOrder", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    public Orders getOrdersByIdOrder() {
        return ordersByIdOrder;
    }

    public void setOrdersByIdOrder(Orders ordersByIdOrder) {
        this.ordersByIdOrder = ordersByIdOrder;
    }

    @ManyToOne
    @JoinColumn(name = "IdBook", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    public Book getBookByIdBook() {
        return bookByIdBook;
    }

    public void setBookByIdBook(Book bookByIdBook) {
        this.bookByIdBook = bookByIdBook;
    }
}
