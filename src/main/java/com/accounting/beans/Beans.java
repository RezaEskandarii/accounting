package com.accounting.beans;

import com.accounting.application.services.AccountAppServiceImpl;
import com.accounting.application.services.AccountGroupAppServiceImpl;
import com.accounting.application.services.BookAppServiceImpl;
import com.accounting.contract.interfaces.AccountAppService;
import com.accounting.contract.interfaces.AccountGroupAppService;
import com.accounting.contract.interfaces.BookAppService;
import com.accounting.domain.interfaces.AccountGroupService;
import com.accounting.domain.interfaces.AccountService;
import com.accounting.domain.interfaces.BookService;
import com.accounting.domain.services.AccountGroupServiceImpl;
import com.accounting.domain.services.AccountServiceImpl;
import com.accounting.domain.services.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public BookAppService bookAppService() {
        return new BookAppServiceImpl();
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }

    @Bean
    public AccountAppService accountAppService() {
        return new AccountAppServiceImpl();
    }

    @Bean
    public AccountService getAccountService() {
        return new AccountServiceImpl();
    }

    @Bean
    public AccountGroupService getAccountGroupService() {
        return new AccountGroupServiceImpl();
    }

    @Bean
    public AccountGroupAppService getAccountGroupAppService() {
        return new AccountGroupAppServiceImpl();
    }
}
