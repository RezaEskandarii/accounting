package com.accounting.services;

import com.accounting.dto.PaginationInput;
import com.accounting.dto.accountGroups.AccountGroupDto;
import com.accounting.dto.accountGroups.GetAccountGroupDto;
import com.accounting.entitites.AccountGroup;
import com.accounting.exceptions.ItemNotFoundException;
import com.accounting.mapper.AccountGroupMapper;
import com.accounting.repositories.AccountGroupRepository;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AccountGroupService {
    @Autowired
    private AccountGroupRepository accountGroupRepository;

    @Autowired
    private AccountGroupMapper accountGroupMapper;


    public GetAccountGroupDto create(AccountGroupDto AccountGroupDto) {
        var acGroup = accountGroupMapper.mapToAccountGroup(AccountGroupDto);
        accountGroupRepository.save(acGroup);
        return accountGroupMapper.mapToGetAccountGroup(acGroup);
    }

    public GetAccountGroupDto update(AccountGroupDto AccountGroupDto, Long id) {
        var acGroup = accountGroupRepository.findById(id).
                orElseThrow(() -> new ItemNotFoundException(id));

        var ac = accountGroupMapper.mapToAccountGroup(acGroup);
        ac.setId(id);
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

    public void delete(Long id) {
        accountGroupRepository.deleteById(id);
    }
}
