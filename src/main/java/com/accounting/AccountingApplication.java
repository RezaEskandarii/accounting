package com.accounting;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        try {
            SpringApplication.run(AccountingApplication.class, args);
        } catch (Exception e) {
            log.debug(e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("==run application==");
    }
}
