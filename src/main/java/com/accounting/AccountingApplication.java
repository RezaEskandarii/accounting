package com.accounting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AccountingApplication {

    public static void main(String[] args) {

        log.error("application started...");
        SpringApplication.run(AccountingApplication.class, args);
    }

}
