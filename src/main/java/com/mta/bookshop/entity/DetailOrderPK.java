package com.mta.bookshop.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DetailOrderPK implements Serializable {
    private int idOrder;
    private int idBook;

    @Column(name = "IdOrder")
    @Id
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Column(name = "IdBook")
    @Id
    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailOrderPK that = (DetailOrderPK) o;

        if (idOrder != that.idOrder) return false;
        if (idBook != that.idBook) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + idBook;
        return result;
    }
}
