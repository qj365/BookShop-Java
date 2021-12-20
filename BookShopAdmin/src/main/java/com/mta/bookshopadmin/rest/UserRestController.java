package com.mta.bookshopadmin.rest;

import com.mta.bookshopadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping("/Register/CheckUsername")
    public String checkDuplicateUsername(@Param("username") String username){
        return userService.isUernameUnique(username) ? "Ok" : "Duplicate";
    }
}
