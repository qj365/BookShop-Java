package com.mta.bookshop.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Book {
    private int id;
    private String name;
    private int discount;
    private int price;
    private int amount;
    private String photo;
    private String description;
    private int idPublisher;
    private int idCategory;
    private int idAuthor;

    private Publisher publisherByIdPublisher;
    private Category categoryByIdCategory;
    private Author authorByIdAuthor;
    private Collection<DetailOrder> detailOrdersById;

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
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "IdPublisher")
    public int getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }

    @Basic
    @Column(name = "IdCategory")
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Basic
    @Column(name = "IdAuthor")
    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (discount != book.discount) return false;
        if (price != book.price) return false;
        if (amount != book.amount) return false;
        if (idPublisher != book.idPublisher) return false;
        if (idCategory != book.idCategory) return false;
        if (idAuthor != book.idAuthor) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (photo != null ? !photo.equals(book.photo) : book.photo != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + discount;
        result = 31 * result + price;
        result = 31 * result + amount;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + idPublisher;
        result = 31 * result + idCategory;
        result = 31 * result + idAuthor;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "IdPublisher", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    public Publisher getPublisherByIdPublisher() {
        return publisherByIdPublisher;
    }

    public void setPublisherByIdPublisher(Publisher publisherByIdPublisher) {
        this.publisherByIdPublisher = publisherByIdPublisher;
    }

    @ManyToOne
    @JoinColumn(name = "IdCategory", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    public Category getCategoryByIdCategory() {
        return categoryByIdCategory;
    }

    public void setCategoryByIdCategory(Category categoryByIdCategory) {
        this.categoryByIdCategory = categoryByIdCategory;
    }

    @ManyToOne
    @JoinColumn(name = "IdAuthor", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    public Author getAuthorByIdAuthor() {
        return authorByIdAuthor;
    }

    public void setAuthorByIdAuthor(Author authorByIdAuthor) {
        this.authorByIdAuthor = authorByIdAuthor;
    }

    @OneToMany(mappedBy = "bookByIdBook")
    public Collection<DetailOrder> getDetailOrdersById() {
        return detailOrdersById;
    }

    public void setDetailOrdersById(Collection<DetailOrder> detailOrdersById) {
        this.detailOrdersById = detailOrdersById;
    }
}
