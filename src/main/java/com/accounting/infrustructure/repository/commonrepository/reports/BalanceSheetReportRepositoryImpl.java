package com.accounting.infrustructure.repository.commonrepository.reports;

import com.accounting.domain.entitites.Account;
import com.accounting.domain.entitites.Transaction;
import com.accounting.domain.interfaces.repository.BalanceSheetReportRepository;
import com.accounting.infrustructure.repository.jparepository.AccountJpaRepository;
import com.accounting.infrustructure.repository.jparepository.TransactionJpaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public record BalanceSheetReportRepositoryImpl(
        AccountJpaRepository accountJpaRepository,
        TransactionJpaRepository transactionJpaRepository
) implements BalanceSheetReportRepository {

    @Override
    public Map<String, BigDecimal> generateBalanceSheet() {
        Map<String, BigDecimal> balanceSheet = new LinkedHashMap<>();

        // Get all accounts
        var accounts = accountJpaRepository.findAll();

        // Calculate total balance for each account type
        for (Account account : accounts) {
            BigDecimal totalBalance = calculateTotalBalance(account.id);
            balanceSheet.put(account.getAccountType().name(), totalBalance);
        }

        return balanceSheet;
    }

    private BigDecimal calculateTotalBalance(Long accountId) {
        BigDecimal totalBalance = BigDecimal.ZERO;

        var transactions = transactionJpaRepository.findByAccountId(accountId);

        for (Transaction transaction : transactions) {
            BigDecimal debit = transaction.getDebitValue() != null ? transaction.getDebitValue() : BigDecimal.ZERO;
            BigDecimal credit = transaction.getCreditValue() != null ? transaction.getCreditValue() : BigDecimal.ZERO;

            totalBalance = totalBalance.add(credit).subtract(debit);
        }

        return totalBalance;
    }
}
