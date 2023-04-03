package com.accounting.services;

import com.accounting.shared.filters.PaginationInput;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.dto.accounts.GetAccountDTO;
import com.accounting.domain.entitites.Account;
import com.accounting.shared.errors.Errors;
import com.accounting.shared.exceptions.DuplicatedItemException;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.shared.mapper.AccountMapper;
import com.accounting.repositories.interfaces.AccountCrudRepository;
import com.accounting.utils.PageUtils;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountCrudRepository accountRepository;

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
        var result = accountRepository.save(account);
        return accountMapper.mapToGetAccountDTO(result);
    }

    public GetAccountDTO update(AccountDTO accountDTO, Long id) {

        checkDuplicatedFieldsInUpdate(accountDTO, id);
        var mapper = new ModelMapper();
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        var ac = accountRepository.findById(id).
                orElseThrow(() -> new ItemNotFoundException(id));

        mapper.map(accountDTO, ac);
      //  ac.setId(id);
        ac.setAccountGroup(null);
        var result = accountRepository.save(ac);

        return accountMapper.mapToGetAccountDTO(result);
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
            errors.add(Errors.ACCOUNT_NAME_REPEATED_ERROR);

        if (this.findByMainCode(accountDTO.getCode()) != null)
            errors.add(Errors.ACCOUNT_CODE_REPEATED_ERROR);

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
            errors.add(Errors.ACCOUNT_NAME_REPEATED_ERROR);

        ac = this.findByMainCode(accountDTO.getCode());
        if (ac != null && !ac.getId().equals(id))
            errors.add(Errors.ACCOUNT_CODE_REPEATED_ERROR);

        if (errors.size() > 0)
            throw new DuplicatedItemException(errors);
    }
}
