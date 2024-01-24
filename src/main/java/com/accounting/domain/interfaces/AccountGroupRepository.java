package com.accounting.domain.interfaces;

import com.accounting.domain.entitites.AccountGroup;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AccountGroupRepository {
    AccountGroup create(AccountGroup accountGroup);

    AccountGroup update(Long id, AccountGroup accountGroup);

    Optional<AccountGroup> find(Long id);

    Optional<AccountGroup> findByCode(String code);

    void delete(Long id);

    Page<AccountGroup> findAll(PaginationInput input);
}
