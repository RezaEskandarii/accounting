package com.accounting.repositories;

import com.accounting.entitites.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findAccountByCode(String code);

}
