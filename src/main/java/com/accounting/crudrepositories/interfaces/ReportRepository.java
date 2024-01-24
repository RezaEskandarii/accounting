package com.accounting.crudrepositories.interfaces;

import com.accounting.contract.dto.TrialBalanceReportDto;

import java.time.LocalDate;
import java.util.List;


public interface ReportRepository {
    List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate);
}



