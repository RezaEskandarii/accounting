package com.accounting.application.services.ReportServices;

import com.accounting.contract.interfaces.reports.BalanceSheetReportAppService;
import com.accounting.domain.interfaces.repository.BalanceSheetReportRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class BalanceSheetReportAppServiceImpl implements BalanceSheetReportAppService {

    private final BalanceSheetReportRepository balanceSheetReportRepository;

    public BalanceSheetReportAppServiceImpl(BalanceSheetReportRepository balanceSheetReportRepository) {
        this.balanceSheetReportRepository = balanceSheetReportRepository;
    }

    @Override
    public Map<String, BigDecimal> generateBalanceSheet() {
        return balanceSheetReportRepository.generateBalanceSheet();
    }
}
