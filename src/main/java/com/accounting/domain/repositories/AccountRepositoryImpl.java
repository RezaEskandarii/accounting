package com.accounting.domain.repositories;

import com.accounting.domain.entitites.Account;
import com.accounting.domain.interfaces.AccountRepository;
import com.accounting.jparepository.AccountJpaRepository;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.utils.PageUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountRepositoryImpl implements AccountRepository {


    private final AccountJpaRepository accountRepository;

    public AccountRepositoryImpl(AccountJpaRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, Account account) {
        account.id = id;
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> find(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        accountRepository.delete(find(id).get());
    }

    @Override
    public Page<Account> findAll(PaginationInput input) {
        return accountRepository.findAll(PageUtils.GetRequest(input));
    }


}
