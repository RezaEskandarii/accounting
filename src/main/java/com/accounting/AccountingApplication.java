package com.accounting;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication {

    public static void main(String[] args) {
        try {

            SpringApplication.run(AccountingApplication.class, args);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error(e.getCause().getMessage());
        }
    }


}
