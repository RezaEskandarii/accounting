package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountGroupRepository extends JpaRepository<AccountGroup, Long> {
    public AccountGroup findByName(String name);
    public AccountGroup findByCode(String code);
}
