package com.accounting.domain.interfaces;

import com.accounting.shared.filters.PaginationInput;
import com.accounting.domain.entitites.AccountGroup;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AccountGroupRepository {
    public AccountGroup create(AccountGroup accountGroup);

    public AccountGroup update(Long id, AccountGroup accountGroup);

    public Optional<AccountGroup> find(Long id);

    public Optional<AccountGroup> findByCode(String code);

    public void delete(Long id);

    public Page<AccountGroup> findAll(PaginationInput input);
}