package com.accounting.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class ConfigurationReader {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    public String hibernateHBM2DDL;

    @Value("${spring.jpa.database-platform}")
    public String sqlDialect;

    @Value("${spring.jpa.show-sql}")
    public String hibernateShowSQL;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    public String hibernateFormatSQL;

}
