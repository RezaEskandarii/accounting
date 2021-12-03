package com.accounting.services;

import com.accounting.dto.accounts.AccountDTO;
import com.accounting.dto.accounts.GetAccountDTO;
import com.accounting.mapper.AccountMapper;
import com.accounting.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<GetAccountDTO> findAll() {
        var accounts = accountRepository.findAll();
        return accountMapper.mapToAccountDTOCollection(accounts);
    }
}
