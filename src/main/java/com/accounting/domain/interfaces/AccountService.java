package com.accounting.domain.interfaces;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.domain.entitites.Account;
import com.accounting.domain.entitites.Account;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AccountService {


    public Account create(Account account);

    public Account update(Long id, Account account);

    public Optional<Account> find(Long id);

    public void delete(Long id);

    public Page<Account> findAll(PaginationInput input);
    
}
