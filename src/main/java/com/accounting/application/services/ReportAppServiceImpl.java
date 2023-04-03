package com.accounting.application.services;

import com.accounting.contract.dto.TrialBalanceReportDto;
import com.accounting.contract.interfaces.ReportAppService;
import com.accounting.repositories.interfaces.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class ReportAppServiceImpl implements ReportAppService {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public List<TrialBalanceReportDto> getTrialBalanceReport(Long accountId, Long journalId, LocalDate fromDate, LocalDate toDate) {

        return reportRepository.getTrialBalanceReport(accountId, journalId, fromDate, toDate);
    }
}
