package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}