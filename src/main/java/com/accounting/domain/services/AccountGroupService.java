package com.accounting.domain.services;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.domain.entitites.AccountGroup;
import com.accounting.repositories.interfaces.AccountGroupRepository;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Optional;

public class AccountGroupService implements com.accounting.domain.interfaces.AccountGroupService {


    private AccountGroupRepository accountGroupRepository;

    @Autowired
    public AccountGroupService(AccountGroupRepository accountGroupRepository) {
        this.accountGroupRepository = accountGroupRepository;
    }

    @Override
    public AccountGroup create(AccountGroup accountGroup) {
        return accountGroupRepository.save(accountGroup);
    }

    @Override
    public AccountGroup update(Long id, AccountGroup accountGroup) {
        accountGroup.id = id;
        return accountGroupRepository.save(accountGroup);
    }

    @Override
    public Optional<AccountGroup> find(Long id) {
        var result = accountGroupRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

        return Optional.of(result);
    }

    @Override
    public Optional<AccountGroup> findByCode(String code) {
        return Optional.of(accountGroupRepository.findByCode(code));
    }

    @Override
    public void delete(Long id) {
        accountGroupRepository.deleteById(id);
    }

    @Override
    public Page<AccountGroup> findAll(PaginationInput input) {
        return accountGroupRepository.findAll(PageUtils.GetRequest(input));
    }
}
