package com.accounting.config;


import com.accounting.domain.interfaces.repository.UserRepository;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .locations("db/migrations/default")
                .dataSource(dataSource)
//                .schemas("public")
                .load();
        return flyway;
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, DataSource dataSource) {
        return args -> flyway(dataSource).migrate();
    }
}