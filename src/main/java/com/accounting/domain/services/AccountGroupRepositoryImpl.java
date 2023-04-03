package com.accounting.domain.services;

import com.accounting.domain.interfaces.AccountGroupRepository;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.domain.entitites.AccountGroup;
import com.accounting.repositories.interfaces.AccountGroupCrudRepository;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Optional;

public class AccountGroupRepositoryImpl implements AccountGroupRepository {


    @Autowired
    private AccountGroupCrudRepository accountGroupRepository;


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
