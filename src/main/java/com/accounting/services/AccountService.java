package com.accounting.services;

import com.accounting.dto.PaginationInput;
import com.accounting.dto.accounts.AccountDTO;
import com.accounting.dto.accounts.GetAccountDTO;
import com.accounting.entitites.Account;
import com.accounting.entitites.BaseEntity;
import com.accounting.exceptions.ItemNotFoundException;
import com.accounting.mapper.AccountMapper;
import com.accounting.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private Paginator<Account> accountPaginator;

    public GetAccountDTO create(AccountDTO accountDTO) {
        var account = accountMapper.mapToAccount(accountDTO);
        accountRepository.save(account);
        return accountMapper.mapToGetAccountDTO(account);
    }

    public Page<Account> findAll(PaginationInput input) {
        var accounts = accountPaginator.getResult(input);

        accounts.map(ac -> accountMapper.mapToAccountDTO(ac));
        return accounts;
    }

    public List<GetAccountDTO> findAll() {
        var accounts = accountRepository.findAll();
        return accountMapper.mapToGetAccountDTOCollection(accounts);
    }

    public GetAccountDTO findById(Long id) {
        var ac = accountRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        return accountMapper.mapToGetAccountDTO(ac);
    }
}
