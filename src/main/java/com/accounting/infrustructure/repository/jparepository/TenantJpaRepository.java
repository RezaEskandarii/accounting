package com.accounting.infrustructure.repository.jparepository;

import com.accounting.domain.entitites.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TenantJpaRepository extends JpaRepository<Tenant, Long> {
}
