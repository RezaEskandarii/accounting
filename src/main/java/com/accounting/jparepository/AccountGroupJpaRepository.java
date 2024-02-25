package com.accounting.jparepository;

import com.accounting.domain.entitites.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountGroupJpaRepository extends JpaRepository<AccountGroup, Long> {
    AccountGroup findByName(String name);

    AccountGroup findByCode(String code);

    AccountGroup findByIdAndCode(Long id, String code);
}
