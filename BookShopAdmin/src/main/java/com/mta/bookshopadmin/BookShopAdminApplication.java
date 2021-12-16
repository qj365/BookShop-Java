package com.mta.bookshopadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.mta.bookshop.entity")

public class BookShopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShopAdminApplication.class, args);
    }

}
