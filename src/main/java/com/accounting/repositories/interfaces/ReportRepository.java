package com.accounting.repositories.interfaces;

import com.accounting.domain.entitites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ReportRepository extends JpaRepository<Transaction, Long> {

    @Repository
    public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        @Query("SELECT t FROM Transaction t "
                + "JOIN t.book b "
                + "JOIN t.account a "
                + "JOIN t.journal j "
                + "WHERE (:fromDate IS NULL OR t.createdAt >= :fromDate) "
                + "AND (:toDate IS NULL OR t.createdAt <= :toDate) "
                + "AND (:accountID IS NULL OR a.id = :accountID) "
                + "AND (:bookID IS NULL OR b.id = :bookID)")
        List<Transaction> findByFilter(@Param("fromDate") LocalDate fromDate,
                                       @Param("toDate") LocalDate toDate,
                                       @Param("accountID") Long accountID,
                                       @Param("bookID") Long bookID);
    }


}
