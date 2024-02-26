package com.accounting.contract.interfaces.reports;

import com.accounting.contract.dto.TrialBalanceReportDto;

import java.time.LocalDate;
import java.util.List;


public interface TrialBalanceReportService {
    List<TrialBalanceReportDto> getReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate);
}



