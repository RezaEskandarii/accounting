package com.accounting;


import com.accounting.config.ConfigurationReader;
import com.accounting.domain.entitites.User;
import com.accounting.services.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "MultiTenant Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication implements CommandLineRunner {

    private final UserService userService;
    private final ConfigurationReader configurationReader;

    public AccountingApplication(UserService userService, ConfigurationReader configurationReader) {
        this.userService = userService;
        this.configurationReader = configurationReader;
    }


    public static void main(String[] args) {
        SpringApplication.run(AccountingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("########## application started on port %s ##########", configurationReader.serverPort);
        try {

            var username = "admin";
            var user = userService.findByUsername(username);

            if (user.isEmpty()) {
                var adminUser = new User();
                adminUser.setPassword("123456");
                adminUser.setUsername(username);
                adminUser.setEmail("admin@admin.cofm");
                adminUser.setEnabled(true);
                adminUser.setAccountNonExpired(true);
                adminUser.setCredentialsNonExpired(true);
                adminUser.setAccountNonLocked(true);
                userService.create(adminUser);

                System.out.println(adminUser.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
