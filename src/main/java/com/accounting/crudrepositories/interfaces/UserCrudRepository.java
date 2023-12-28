package com.accounting.crudrepositories.interfaces;

import com.accounting.domain.entitites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserCrudRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}