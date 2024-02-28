package com.accounting.infrustructure.repository.jparepository;

import com.accounting.domain.entitites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserJpaRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}