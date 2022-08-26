package com.accounting.validator;

import com.accounting.contract.dto.journal.JournalDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JournalValidator {

    public boolean validate(JournalDto journal) {

        if (journal == null)
            return false;

        if (journal.getTransactions() == null)
            return false;

        if (journal.getTransactions().size() == 0)
            return false;

        BigDecimal totalDebit = BigDecimal.valueOf(0);
        BigDecimal totalCredit = BigDecimal.valueOf(0);

        for (var tnx : journal.getTransactions()) {
            if (tnx.getDebitValue().compareTo(BigDecimal.ZERO) != 0
                    && tnx.getCreditValue().compareTo(BigDecimal.ZERO) != 0) {
                return false;
            }

            totalDebit.add(tnx.getDebitValue());
            totalCredit.add(tnx.getCreditValue());

            if (!totalCredit.equals(totalDebit))
                return false;
        }

        return true;
    }


}
