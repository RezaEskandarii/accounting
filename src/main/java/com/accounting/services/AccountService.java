package com.accounting.services;

import com.accounting.dto.PaginationInput;
import com.accounting.dto.accounts.AccountDTO;
import com.accounting.dto.accounts.GetAccountDTO;
import com.accounting.entitites.Account;
import com.accounting.errors.Errors;
import com.accounting.exceptions.DuplicatedItemException;
import com.accounting.exceptions.ItemNotFoundException;
import com.accounting.mapper.AccountMapper;
import com.accounting.repositories.AccountRepository;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountGroupService accountGroupService;


    public GetAccountDTO create(AccountDTO accountDTO) {

        // check to duplicated fields
        checkDuplicatedFieldsInCreate(accountDTO);

        var account = accountMapper.mapToAccount(accountDTO);
        var accountGroup = accountGroupService.findAccountGroupById(accountDTO.getAccountGroupId());
        account.setAccountGroup(accountGroup);
        account.setCode(String.format("%s%s", accountGroup.getCode(), account.getCode()));
        accountRepository.save(account);
        return accountMapper.mapToGetAccountDTO(account);
    }

    public GetAccountDTO update(AccountDTO accountDTO, Long id) {

        checkDuplicatedFieldsInUpdate(accountDTO, id);

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

    public GetAccountDTO findByMainCode(String code) {
        var ac = this.accountRepository.findAccountByCodeEndingWith(code);
        if (ac == null)
            return null;

        return accountMapper.mapToGetAccountDTO(ac);
    }

    /**
     * check duplicated fields in create operation.
     *
     * @param accountDTO
     */
    private void checkDuplicatedFieldsInCreate(AccountDTO accountDTO) {
        List<String> errors = new ArrayList<>();

        if (this.findByName(accountDTO.getName()) != null)
            errors.add(Errors.AccountNameDuplicateError);

        if (this.findByMainCode(accountDTO.getCode()) != null)
            errors.add(Errors.AccountCodeDuplicateError);

        if (errors.size() > 0)
            throw new DuplicatedItemException(errors);
    }


    /**
     * check duplicated fields in update operation.
     *
     * @param accountDTO
     * @param id
     */
    private void checkDuplicatedFieldsInUpdate(AccountDTO accountDTO, Long id) {
        List<String> errors = new ArrayList<>();

        var ac = this.findByName(accountDTO.getName());
        if (ac != null && !ac.getId().equals(id))
            errors.add(Errors.AccountNameDuplicateError);

        ac = this.findByMainCode(accountDTO.getCode());
        if (ac != null && !ac.getId().equals(id))
            errors.add(Errors.AccountCodeDuplicateError);

        if (errors.size() > 0)
            throw new DuplicatedItemException(errors);
    }
}
