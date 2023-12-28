package com.accounting.beans;

import com.accounting.domain.repositories.*;
import com.accounting.crudrepositories.interfaces.ReportRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Repositories {

    @Bean()
    public ReportRepository getReportRepository() {
        return new ReportRepositoryImpl();
    }

}
