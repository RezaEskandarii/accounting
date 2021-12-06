package com.accounting.services;

import com.accounting.dto.PaginationInput;
import com.accounting.dto.accounts.AccountDTO;
import com.accounting.dto.accounts.GetAccountDTO;
import com.accounting.entitites.Account;
import com.accounting.exceptions.ItemNotFoundException;
import com.accounting.mapper.AccountMapper;
import com.accounting.repositories.AccountRepository;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    public GetAccountDTO create(AccountDTO accountDTO) {
        var account = accountMapper.mapToAccount(accountDTO);
        accountRepository.save(account);
        return accountMapper.mapToGetAccountDTO(account);
    }

    public GetAccountDTO update(AccountDTO accountDTO, Long id) {
        var ac = accountRepository.findById(id).
                orElseThrow(() -> new ItemNotFoundException(id));
        ac = accountMapper.mapToAccount(accountDTO);

        accountRepository.save(ac);

        return accountMapper.mapToGetAccountDTO(ac);
    }

    public Page<Account> findAll(PaginationInput input) {

        var accounts = accountRepository.findAll(PageUtils.GetRequest(input));
        accounts.map(ac -> accountMapper.mapToAccountDTO(ac));
        return accounts;
    }


    public GetAccountDTO findById(Long id) {
        var ac = accountRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        return accountMapper.mapToGetAccountDTO(ac);
    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
