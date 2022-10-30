package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
