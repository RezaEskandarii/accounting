package com.accounting.application.services;

import com.accounting.contract.dto.TrialBalanceReportDto;
import com.accounting.contract.interfaces.appservices.ReportAppService;
import com.accounting.contract.interfaces.reports.TrialBalanceReportService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReportAppServiceImpl implements ReportAppService {


    final TrialBalanceReportService reportRepository;

    public ReportAppServiceImpl(TrialBalanceReportService reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate) {

        return reportRepository.getReport(accountId, journalId, fromDate, toDate);
    }
}
