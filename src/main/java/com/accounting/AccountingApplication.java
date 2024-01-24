package com.accounting;


import com.accounting.config.ConfigurationReader;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;


@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @Info(title = "MultiTenant Accounting API", version = "2.0", description = "Accounting API Information"))
public class AccountingApplication implements CommandLineRunner {

    private final ConfigurationReader configurationReader;

    public AccountingApplication(ConfigurationReader configurationReader) {

        this.configurationReader = configurationReader;
    }

    public static void main(String[] args) {
        try {

            SpringApplication.run(AccountingApplication.class, args);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error(e.getCause().getMessage());
        }
    }


    @Override
    public void run(String... args) throws Exception {
        InetAddress localhost = InetAddress.getLocalHost();
        String ipAddress = localhost.getHostAddress();


        System.out.printf("running on %s:%d", ipAddress, configurationReader.serverPort);
    }

    private void seedAdminUser() {
//        var username = "admin";
//        var user = userService.findByUsername(username);
//
//        if (user.isEmpty()) {
//            var adminUser = new User();
//            adminUser.setUsername(username);
//            adminUser.setPassword(username);
//            adminUser.setEnabled(true);
//
//            userService.create(adminUser);
     //   }
    }
}
