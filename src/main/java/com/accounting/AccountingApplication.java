package com.accounting;

import com.accounting.repositories.NoteRepository;
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
    NoteRepository userService;

    @Override
    public void run(String... args) throws Exception {
        try {
            userService.findAll().forEach(note -> System.out.println(note.getText()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
