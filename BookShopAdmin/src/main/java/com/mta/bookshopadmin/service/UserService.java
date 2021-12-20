package com.mta.bookshopadmin.service;

import com.mta.bookshop.entity.User;
import com.mta.bookshopadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean isUernameUnique(String username){
        User user = userRepository.getUserByUsername(username);
        return user == null;
    }
}
