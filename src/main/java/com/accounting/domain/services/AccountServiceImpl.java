package com.accounting.domain.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.domain.entitites.Account;
import com.accounting.domain.interfaces.AccountService;
import com.accounting.repositories.interfaces.AccountRepository;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;


import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, Account account) {
        return null;
    }

    @Override
    public Optional<Account> find(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        accountRepository.delete(find(id).get());
    }

    @Override
    public Page<Account> findAll(PaginationInput input) {
        return accountRepository.findAll(PageUtils.GetRequest(input));
    }
}
