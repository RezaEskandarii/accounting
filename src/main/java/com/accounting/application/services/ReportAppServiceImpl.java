package com.accounting.application.services;

import com.accounting.contract.dto.TrialBalanceReportDto;
import com.accounting.contract.interfaces.ReportAppService;
import com.accounting.crudrepositories.interfaces.ReportRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReportAppServiceImpl implements ReportAppService {


    final ReportRepository reportRepository;

    public ReportAppServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate) {

        return reportRepository.getTrialBalanceReport(accountId, journalId, fromDate, toDate);
    }
}
