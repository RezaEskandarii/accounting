package com.accounting.jparepository;

import com.accounting.domain.entitites.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface JournalCrudRepository extends JpaRepository<Journal, Long> {

}
