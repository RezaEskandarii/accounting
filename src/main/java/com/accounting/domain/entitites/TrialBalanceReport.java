package com.accounting.domain.entitites;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class TrialBalanceReport {
    private BigDecimal creditTotal;
    private BigDecimal debitTotal;
    private long accountId;
    private long bookId;
}
