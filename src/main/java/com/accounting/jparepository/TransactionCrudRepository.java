package com.accounting.jparepository;

import com.accounting.domain.entitites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TransactionCrudRepository extends JpaRepository<Transaction, Long> {

    int countByBook(Long bookId);
}