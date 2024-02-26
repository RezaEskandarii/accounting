package com.accounting.jparepository;

import com.accounting.domain.entitites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TransactionJpaRepository extends JpaRepository<Transaction, Long> {

    int countByBook(Long bookId);

    List<Transaction> findByAccountId(Long accountId);
}
