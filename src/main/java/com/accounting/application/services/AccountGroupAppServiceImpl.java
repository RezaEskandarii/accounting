package com.accounting.application.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.contract.dto.accounts.AccountDTO;
import com.accounting.contract.interfaces.AccountGroupAppService;
import com.accounting.domain.interfaces.AccountGroupService;
import com.accounting.shared.mapper.AccountGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class AccountGroupAppServiceImpl implements AccountGroupAppService {

    private AccountGroupService accountGroupService;

    private AccountGroupMapper accountGroupMapper;

    @Autowired
    public AccountGroupAppServiceImpl(AccountGroupService accountGroupService, AccountGroupMapper accountGroupMapper) {
        this.accountGroupService = accountGroupService;
        this.accountGroupMapper = accountGroupMapper;
    }

    @Override
    public AccountGroupDto create(AccountGroupDto groupDto) {
        var ac = accountGroupMapper.mapToAccountGroup(groupDto);
        var result = accountGroupService.create(ac);
        return accountGroupMapper.mapToAccountGroupDto(result);
    }

    @Override
    public AccountGroupDto findById(long id) {
        var ac = accountGroupService.find(id);
        return accountGroupMapper.mapToAccountGroupDto(ac.get());
    }

    @Override
    public AccountGroupDto findByCode(String code) {
        var ac = accountGroupService.findByCode(code);
        return accountGroupMapper.mapToAccountGroupDto(ac.get());
    }

    @Override
    public AccountGroupDto update(long id, AccountGroupDto groupDto) {
        var ac = accountGroupMapper.mapToAccountGroup(groupDto);
        return accountGroupMapper.mapToAccountGroupDto(accountGroupService.update(id, ac));
    }

    @Override
    public void delete(long id) {
        accountGroupService.delete(id);
    }

    @Override
    public Page<AccountGroupDto> findAll(PaginationInput input) {
        var accounts = accountGroupService.findAll(input);
        return accounts.map(b -> accountGroupMapper.mapToAccountGroupDto(b));
    }
}
