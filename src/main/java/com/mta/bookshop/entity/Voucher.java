package com.mta.bookshop.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Voucher {
    private int id;
    private int discount;
    private Date startDate;
    private Date endDate;
    private String name;
    private Collection<Orders> ordersById;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Discount")
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "StartDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "EndDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voucher voucher = (Voucher) o;

        if (id != voucher.id) return false;
        if (discount != voucher.discount) return false;
        if (startDate != null ? !startDate.equals(voucher.startDate) : voucher.startDate != null) return false;
        if (endDate != null ? !endDate.equals(voucher.endDate) : voucher.endDate != null) return false;
        if (name != null ? !name.equals(voucher.name) : voucher.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + discount;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "voucherByIdVoucher")
    public Collection<Orders> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
    }
}
