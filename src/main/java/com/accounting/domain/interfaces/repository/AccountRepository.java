package com.accounting.domain.interfaces.repository;

import com.accounting.domain.entitites.Account;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

import java.util.Optional;


public interface AccountRepository {


    Account create(Account account);

    Account update(Long id, Account account);

    Optional<Account> find(Long id);

    void delete(Long id);

    Page<Account> findAll(PaginationInput input);
    
}
