package com.accounting.application.services.ReportServices;

import com.accounting.contract.dto.TrialBalanceReportDto;
import com.accounting.contract.interfaces.appservices.TrialBalanceReportAppService;
import com.accounting.contract.interfaces.reports.TrialBalanceReportRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TrialBalanceReportAppServiceImpl implements TrialBalanceReportAppService {


    final TrialBalanceReportRepository reportRepository;

    public TrialBalanceReportAppServiceImpl(TrialBalanceReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate) {

        return reportRepository.getReport(accountId, journalId, fromDate, toDate);
    }
}
