package com.accounting.services;

import com.accounting.dto.PaginationInput;
import com.accounting.dto.accountGroups.AccountGroupDto;
import com.accounting.dto.accountGroups.GetAccountGroupDto;
import com.accounting.entitites.AccountGroup;
import com.accounting.errors.Errors;
import com.accounting.exceptions.DuplicatedItemException;
import com.accounting.exceptions.ItemNotFoundException;
import com.accounting.mapper.AccountGroupMapper;
import com.accounting.repositories.AccountGroupRepository;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountGroupService {
    @Autowired
    private AccountGroupRepository accountGroupRepository;

    @Autowired
    private AccountGroupMapper accountGroupMapper;


    public GetAccountGroupDto create(AccountGroupDto dto) {
        var acGroup = accountGroupMapper.mapToAccountGroup(dto);
        checkDuplicatedFieldsInCreate(dto);
        accountGroupRepository.save(acGroup);
        return accountGroupMapper.mapToGetAccountGroup(acGroup);
    }

    public GetAccountGroupDto update(AccountGroupDto AccountGroupDto, Long id) {
        var acGroup = accountGroupRepository.findById(id).
                orElseThrow(() -> new ItemNotFoundException(id));

        var ac = accountGroupMapper.mapToAccountGroup(acGroup);
       // ac.setId(id);
        accountGroupRepository.save(ac);

        return accountGroupMapper.mapToGetAccountGroup(ac);
    }

    public Page<AccountGroup> findAll(PaginationInput input) {

        var accounts = accountGroupRepository.findAll(PageUtils.GetRequest(input));
        accounts.map(ac -> accountGroupMapper.mapToGetAccountGroup(ac));
        return accounts;
    }


    public GetAccountGroupDto findById(Long id) {
        var ac = accountGroupRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        return accountGroupMapper.mapToGetAccountGroup(ac);
    }

    public AccountGroup findAccountGroupById(Long id) {
        return accountGroupRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void delete(Long id) {
        accountGroupRepository.deleteById(id);
    }

    public AccountGroupDto findByName(String name) {
        return accountGroupMapper.mapToAccountGroupDto(accountGroupRepository.findByName(name));
    }

    public AccountGroupDto findByCode(String code) {
        return accountGroupMapper.mapToAccountGroupDto(accountGroupRepository.findByCode(code));
    }

    private void checkDuplicatedFieldsInCreate(AccountGroupDto dto) {
        List<String> errors = new ArrayList<>();

        if (this.findByName(dto.getName()) != null)
            errors.add(Errors.AccountNameDuplicateError);

        if (this.findByCode(dto.getCode()) != null)
            errors.add(Errors.AccountCodeDuplicateError);

        if (errors.size() > 0)
            throw new DuplicatedItemException(errors);
    }
}
