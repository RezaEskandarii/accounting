package com.accounting;

import com.accounting.entitites.Account;
import com.accounting.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountingApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(AccountingApplication.class, args);
    }

    @Autowired
    UserRepository userService;

    @Override
    public void run(String... args) throws Exception {
        try {
            var a = new Account();

            userService.findAll().forEach(note -> System.out.println(note));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
