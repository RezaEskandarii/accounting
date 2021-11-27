package com.accounting.services;

import com.accounting.dto.accounts.CreateAccountDTO;
import com.accounting.entitites.Account;
import com.accounting.mapper.AccountMapper;
import com.accounting.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public Account create(CreateAccountDTO accountDTO) {
        var account = accountMapper.MapToAccount(accountDTO);
        accountRepository.save(account);
        return account;
    }
}
