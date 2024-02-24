package com.accounting.domain.repositories;

import com.accounting.contract.dto.TrialBalanceReportDto;
import com.accounting.domain.entitites.Transaction;
import com.accounting.jparepository.ReportRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class ReportRepositoryImpl implements ReportRepository {


    private final EntityManagerFactory factory;

    public ReportRepositoryImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate) {

        var entityManager = factory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TrialBalanceReportDto> query = cb.createQuery(TrialBalanceReportDto.class);
        Root<Transaction> root = query.from(Transaction.class);

        Expression<BigDecimal> sumCredits = cb.sum(root.get("creditValue"));
        Expression<BigDecimal> sumDebits = cb.sum(root.get("debitValue"));
        Expression<BigDecimal> balance = cb.diff(sumCredits, sumDebits);

        Predicate predicate = cb.conjunction();
        if (accountId != null) {
            predicate = cb.and(predicate, cb.equal(root.get("account").get("id"), accountId));
        }
        if (journalId != null) {
            predicate = cb.and(predicate, cb.equal(root.get("journal").get("id"), journalId));
        }
        if (fromDate != null) {
            predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("createdAt"), fromDate.atStartOfDay()));
        }
        if (toDate != null) {
            predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("createdAt"), toDate.atTime(LocalTime.MAX)));
        }

        query.multiselect(
                        root.get("account").get("id"),
                        root.get("account").get("name"),
                        sumDebits,
                        sumCredits,
                        balance).
                groupBy(root.get("account").get("id"),
                        root.get("account").get("name")
                ).where(predicate);

        return entityManager.createQuery(query).getResultList();

    }
}
