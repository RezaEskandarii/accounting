package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface JournalCrudRepository extends JpaRepository<Journal, Long> {

}
