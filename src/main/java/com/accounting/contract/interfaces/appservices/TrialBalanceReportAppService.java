package com.accounting.contract.interfaces.appservices;

import com.accounting.contract.dto.TrialBalanceReportDto;

import java.time.LocalDate;
import java.util.List;

public interface TrialBalanceReportAppService {
    List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate);
}
