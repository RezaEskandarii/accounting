package com.accounting;

import com.accounting.repositories.interfaces.JournalRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "MultiTenant Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication {

    public static void main(String[] args) {
        System.out.println("*********application started*********");
        SpringApplication.run(AccountingApplication.class, args);
    }

}
