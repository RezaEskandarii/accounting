package com.accounting.beans;

import com.accounting.application.services.*;
import com.accounting.contract.interfaces.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppServices {

    @Bean
    public BookAppService bookAppService() {
        return new BookAppServiceImpl();
    }

    @Bean
    public AccountAppService accountAppService() {
        return new AccountAppServiceImpl();
    }


    @Bean
    public AccountGroupAppService getAccountGroupAppService() {
        return new AccountGroupAppServiceImpl();
    }


    @Bean
    public JournalAppService getJournalAppServiceBean() {
        return new JournalAppServiceImpl();
    }

    @Bean
    public ReportAppService getReportAppServiceBean() {
        return new ReportAppServiceImpl();
    }
}
