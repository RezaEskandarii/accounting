package com.accounting.repositories;

import com.accounting.entitites.AccountGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountGroupRepository extends JpaRepository<AccountGroup, Long> {
}
