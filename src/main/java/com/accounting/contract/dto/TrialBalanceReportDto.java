package com.accounting.contract.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
public class TrialBalanceReportDto {

    private Long accountId;
    private String accountName;
    private BigDecimal sumDebits;
    private BigDecimal sumCredits;
    private BigDecimal balance;

    public TrialBalanceReportDto( Long accountId, String accountName, BigDecimal sumDebits, BigDecimal sumCredits, BigDecimal balance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.sumDebits = sumDebits;
        this.sumCredits = sumCredits;
        this.balance = balance;
    }
}
