package com.accounting;

import com.accounting.repositories.interfaces.JournalRepository;
import com.accounting.repositories.interfaces.TenantRepository;
import com.accounting.repositories.interfaces.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;


@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "MultiTenant Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication implements CommandLineRunner {


    @Autowired
    private JournalRepository journalRepository;

    public static void main(String[] args) {

        try {
            SpringApplication.run(AccountingApplication.class, args);
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            var f = journalRepository.findAllAccountsNative();
            f.stream().map(t -> t.id).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
