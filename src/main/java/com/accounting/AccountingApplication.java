package com.accounting;

import com.accounting.entitites.Journal;
import com.accounting.entitites.Transaction;
import com.accounting.repositories.JournalRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "MultiTenant Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication  implements CommandLineRunner {

    public static void main(String[] args) {

        log.error("application started...");
        SpringApplication.run(AccountingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
