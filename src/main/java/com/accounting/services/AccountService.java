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

    @Autowired
    private AccountGroupService accountGroupService;

    public GetAccountDTO create(AccountDTO accountDTO) {
        var account = accountMapper.mapToAccount(accountDTO);
        var accountGroup = accountGroupService.findAccountGroupById(accountDTO.getAccountGroupId());
        account.setAccountGroup(accountGroup);
        account.setCode(String.format("%s%s", accountGroup.getCode(), account.getCode()));
        accountRepository.save(account);
        return accountMapper.mapToGetAccountDTO(account);
    }

    public GetAccountDTO update(AccountDTO accountDTO, Long id) {
        var ac = accountRepository.findById(id).
                orElseThrow(() -> new ItemNotFoundException(id));

        ac = accountMapper.mapToAccount(accountDTO);
        ac.setId(id);
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

    public GetAccountDTO findByName(String name) {
        var ac = this.accountRepository.findAccountByName(name);
        if (ac == null)
            return null;

        return accountMapper.mapToGetAccountDTO(ac);
    }

    public GetAccountDTO findByCode(String code) {
        var ac = this.accountRepository.findAccountByCode(code);
        if (ac == null)
            return null;

        return accountMapper.mapToGetAccountDTO(ac);
    }
}
