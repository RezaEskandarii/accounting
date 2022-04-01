package com.accounting.beans;

import com.accounting.application.services.BookAppServiceImpl;
import com.accounting.contract.interfaces.BookAppService;
import com.accounting.domain.interfaces.BookService;
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

}
