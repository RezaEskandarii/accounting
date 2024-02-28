package com.accounting.infrustructure.repository.jparepository;

import com.accounting.domain.entitites.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String roleName);
}
