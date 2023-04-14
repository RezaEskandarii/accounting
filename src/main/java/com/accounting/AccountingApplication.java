package com.accounting;


import com.accounting.domain.entitites.User;
import com.accounting.services.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;


@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "MultiTenant Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication implements CommandLineRunner {

    private final UserService userService;

    public AccountingApplication(UserService userService) {
        this.userService = userService;
    }


    public static void main(String[] args) {
        System.out.println("########## application started ##########");
        SpringApplication.run(AccountingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            Desktop.getDesktop().browse(new URI("https://www.google.com"));

            var user = userService.findByUsername("ad");

            if (user.isEmpty()) {
                var adminUser = new User();
                adminUser.setPassword("123456");
                adminUser.setUsername("ad");
                adminUser.setEmail("admin@admin.cofm");
                userService.createUser(adminUser);

                System.out.println(adminUser.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
