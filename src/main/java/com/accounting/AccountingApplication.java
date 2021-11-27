package com.accounting;

import com.accounting.dto.accounts.CreateAccountDTO;
import com.accounting.services.AccountService;
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
    AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        try {
            var a = new CreateAccountDTO();
            a.setCode("12345");
            a.setDescription("just for test");
            a.setName("ddd");
            a.setRoot(false);
            a.setMeta(new AppJSON());
            accountService.create(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
