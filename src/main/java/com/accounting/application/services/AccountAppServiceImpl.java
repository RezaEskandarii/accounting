package com.accounting.application.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import com.accounting.contract.interfaces.AccountAppService;
import com.accounting.domain.interfaces.AccountService;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.shared.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class AccountAppServiceImpl implements AccountAppService {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public AccountDTO create(AccountCreateDto accountCreateDto) {
        var ac = accountMapper.mapToAccount(accountCreateDto);
        var result = accountService.create(ac);
        return accountMapper.mapToAccountDTO(result);
    }

    @Override
    public AccountDTO update(Long id, AccountUpdateDto accountUpdateDto) {
        var ac = accountMapper.mapToAccount(accountUpdateDto);
        var result = accountService.update(id, ac);
        return accountMapper.mapToAccountDTO(result);
    }

    @Override
    public AccountDTO find(Long id) {
        var result = accountService.find(id).orElseThrow(() -> new ItemNotFoundException(id));

        return accountMapper.mapToAccountDTO(result);
    }

    @Override
    public void delete(Long id) {
        accountService.delete(id);
    }

    @Override
    public Page<AccountDTO> findAll(PaginationInput input) {
        var accounts = accountService.findAll(input);
        return accounts.map(b -> accountMapper.mapToAccountDTO(b));
    }
}
