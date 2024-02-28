package com.accounting.application.services;

import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.contract.interfaces.appservices.AccountGroupAppService;
import com.accounting.domain.interfaces.repository.AccountGroupRepository;
import com.accounting.shared.exceptions.DuplicatedItemException;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.shared.mapper.AccountGroupMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountGroupAppServiceImpl implements AccountGroupAppService {


    final AccountGroupRepository accountGroupService;
    final AccountGroupMapper accountGroupMapper;

    public AccountGroupAppServiceImpl(AccountGroupRepository accountGroupService, AccountGroupMapper accountGroupMapper) {
        this.accountGroupService = accountGroupService;
        this.accountGroupMapper = accountGroupMapper;
    }


    @Override
    public AccountGroupDto create(AccountGroupDto groupDto) {
        throwIfAccountGroupCodeDuplicated(groupDto.getCode());

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
        throwIfAccountGroupCodeDuplicated(id, groupDto.getCode());
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
        return accounts.map(accountGroupMapper::mapToAccountGroupDto);
    }

    private void throwIfAccountGroupCodeDuplicated(String code) {
        var ac = accountGroupService.findByCode(code);
        if (ac.isPresent()) {
            throw new DuplicatedItemException(duplicatedCodeError(code));
        }
    }

    private void throwIfAccountGroupCodeDuplicated(Long id, String code) {
        var ac = accountGroupService.findByIdAndCode(id, code);
        if (ac.isPresent()) {
            throw new DuplicatedItemException(duplicatedCodeError(code));
        }
    }

    private List<String> duplicatedCodeError(String code) {
        return List.of(String.format("%s code is duplicated", code));
    }

}
