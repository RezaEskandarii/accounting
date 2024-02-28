package com.accounting.application.reports;

import com.accounting.contract.dto.TrialBalanceReportDto;
import com.accounting.contract.interfaces.appservices.TrialBalanceReportAppService;
import com.accounting.contract.interfaces.reports.TrialBalanceReportService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TrialBalanceReportAppServiceImpl implements TrialBalanceReportAppService {


    final TrialBalanceReportService reportRepository;

    public TrialBalanceReportAppServiceImpl(TrialBalanceReportService reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate) {

        return reportRepository.getReport(accountId, journalId, fromDate, toDate);
    }
}
