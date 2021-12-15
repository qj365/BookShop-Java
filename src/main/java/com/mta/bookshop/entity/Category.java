package com.mta.bookshop.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    private int id;
    private String name;
    private Collection<Book> booksById;

    @Id
    @Column(name = "Id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByIdCategory")
    public Collection<Book> getBooksById() {
        return booksById;
    }

    public void setBooksById(Collection<Book> booksById) {
        this.booksById = booksById;
    }
}