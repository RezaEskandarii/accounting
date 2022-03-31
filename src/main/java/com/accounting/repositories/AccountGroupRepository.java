package com.accounting.repositories;

import com.accounting.entitites.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountGroupRepository extends JpaRepository<AccountGroup, Long> {
    public AccountGroup findByName(String name);

    public AccountGroup findByCode(String code);
}
