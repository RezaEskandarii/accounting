package com.accounting.jparepository;

import com.accounting.domain.entitites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    Account findAccountByCode(String code);

    Account findAccountByName(String name);

    Account findAccountByCodeEndingWith(String code);

    Account findAccountByNameAndId(String name, Long id);

    Account findAccountByCodeAndId(String code, Long id);

}


