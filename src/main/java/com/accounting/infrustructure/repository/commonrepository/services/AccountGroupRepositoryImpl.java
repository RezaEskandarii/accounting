package com.accounting.infrustructure.repository.commonrepository.services;

import com.accounting.domain.entitites.AccountGroup;
import com.accounting.domain.interfaces.repository.AccountGroupRepository;
import com.accounting.infrustructure.repository.jparepository.AccountGroupJpaRepository;
import com.accounting.shared.exceptions.ItemNotFoundException;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountGroupRepositoryImpl implements AccountGroupRepository {


    private final AccountGroupJpaRepository accountGroupRepository;

    public AccountGroupRepositoryImpl(AccountGroupJpaRepository accountGroupRepository) {
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
        var account = accountGroupRepository.findByCode(code);
        return account != null ? Optional.of(account) : Optional.empty();
    }

    @Override
    public Optional<AccountGroup> findByIdAndCode(Long id, String code) {
        var result = accountGroupRepository.findByIdAndCode(id, code);
        if (result == null) return Optional.empty();

        return Optional.of(result);
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
