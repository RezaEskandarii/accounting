package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public int countByBook(Long bookId);
}
