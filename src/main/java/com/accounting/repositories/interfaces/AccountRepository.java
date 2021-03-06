package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findAccountByCode(String code);

    public Account findAccountByName(String name);

    public Account findAccountByCodeEndingWith(String code);

    public Account findAccountByNameAndId(String name, Long id);

    public Account findAccountByCodeAndId(String code, Long id);
}


