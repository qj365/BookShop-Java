package com.mta.bookshopadmin.repository;

import com.mta.bookshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User getUserByUsername(String username);
}
