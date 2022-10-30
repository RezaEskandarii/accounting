package com.accounting.domain.interfaces;

import com.accounting.contract.dto.PaginationInput;
import com.accounting.domain.entitites.AccountGroup;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AccountGroupService {
    public AccountGroup create(AccountGroup accountGroup);

    public AccountGroup update(Long id, AccountGroup accountGroup);

    public Optional<AccountGroup> find(Long id);

    public Optional<AccountGroup> findByCode(String code);

    public void delete(Long id);

    public Page<AccountGroup> findAll(PaginationInput input);
}
