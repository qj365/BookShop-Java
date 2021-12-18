package com.mta.bookshop.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Orders {
    private int id;
    private String address;
    private Date orderDate;
    private Date receiveDate;
    private String note;
    private String paymentMethod;
    private Integer idState;
    private Integer idCustomer;
    private Integer idInformation;
    private Integer totalPrice;
    private String reason;
    private Collection<DetailOrder> detailOrdersById;
    private State stateByIdState;
    private Customer customerByIdCustomer;
    private Information informationByIdInformation;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "OrderDate")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "ReceiveDate")
    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Basic
    @Column(name = "Note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "PaymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    @Basic
    @Column(name = "IdState")
    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    @Basic
    @Column(name = "IdCustomer")
    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Basic
    @Column(name = "IdInformation")
    public Integer getIdInformation() {
        return idInformation;
    }

    public void setIdInformation(Integer idInformation) {
        this.idInformation = idInformation;
    }

    @Basic
    @Column(name = "TotalPrice")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "Reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (address != null ? !address.equals(orders.address) : orders.address != null) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;
        if (receiveDate != null ? !receiveDate.equals(orders.receiveDate) : orders.receiveDate != null) return false;
        if (note != null ? !note.equals(orders.note) : orders.note != null) return false;
        if (paymentMethod != null ? !paymentMethod.equals(orders.paymentMethod) : orders.paymentMethod != null)
            return false;
        if (idState != null ? !idState.equals(orders.idState) : orders.idState != null) return false;
        if (idCustomer != null ? !idCustomer.equals(orders.idCustomer) : orders.idCustomer != null) return false;
        if (idInformation != null ? !idInformation.equals(orders.idInformation) : orders.idInformation != null)
            return false;
        if (totalPrice != null ? !totalPrice.equals(orders.totalPrice) : orders.totalPrice != null) return false;
        if (reason != null ? !reason.equals(orders.reason) : orders.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (receiveDate != null ? receiveDate.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (idState != null ? idState.hashCode() : 0);
        result = 31 * result + (idCustomer != null ? idCustomer.hashCode() : 0);
        result = 31 * result + (idInformation != null ? idInformation.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByIdOrder")
    public Collection<DetailOrder> getDetailOrdersById() {
        return detailOrdersById;
    }

    public void setDetailOrdersById(Collection<DetailOrder> detailOrdersById) {
        this.detailOrdersById = detailOrdersById;
    }



    @ManyToOne
    @JoinColumn(name = "IdState", referencedColumnName = "Id", insertable=false, updatable=false)
    public State getStateByIdState() {
        return stateByIdState;
    }

    public void setStateByIdState(State stateByIdState) {
        this.stateByIdState = stateByIdState;
    }

    @ManyToOne
    @JoinColumn(name = "IdCustomer", referencedColumnName = "Id", insertable=false, updatable=false)
    public Customer getCustomerByIdCustomer() {
        return customerByIdCustomer;
    }

    public void setCustomerByIdCustomer(Customer customerByIdCustomer) {
        this.customerByIdCustomer = customerByIdCustomer;
    }

    @ManyToOne
    @JoinColumn(name = "IdInformation", referencedColumnName = "Id", insertable=false, updatable=false)
    public Information getInformationByIdInformation() {
        return informationByIdInformation;
    }

    public void setInformationByIdInformation(Information informationByIdInformation) {
        this.informationByIdInformation = informationByIdInformation;
    }
}
