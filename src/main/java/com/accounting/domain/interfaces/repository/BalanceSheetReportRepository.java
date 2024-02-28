package com.accounting.domain.interfaces.repository;

import java.math.BigDecimal;
import java.util.Map;

public interface BalanceSheetReportRepository {

    Map<String, BigDecimal> generateBalanceSheet();
}
