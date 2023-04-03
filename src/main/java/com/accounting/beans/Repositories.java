package com.accounting.beans;

import com.accounting.domain.interfaces.AccountGroupRepository;
import com.accounting.domain.interfaces.AccountRepository;
import com.accounting.domain.interfaces.BookRepository;
import com.accounting.domain.interfaces.JournalRepository;
import com.accounting.domain.services.*;
import com.accounting.repositories.interfaces.ReportRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repositories {

    @Bean
    public ReportRepository getReportRepository() {
        return new ReportRepositoryImpl();
    }

    @Bean
    public BookRepository getBookRepository() {
        return new BookRepositoryImpl();
    }

    @Bean
    public AccountRepository getAccountRepository() {
        return new AccountRepositoryImpl();
    }

    @Bean
    public AccountGroupRepository getAccountGroupRepository() {
        return new AccountGroupRepositoryImpl();
    }

    @Bean
    public JournalRepository getJournalRepository() {
        return new JournalRepositoryImpl();
    }
}
