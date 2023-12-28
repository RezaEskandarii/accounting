package com.accounting.crudrepositories.interfaces;

import com.accounting.domain.entitites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleCrudRepository extends JpaRepository<Role, Long> {
    public Optional<Role> findByName(String roleName);
}
