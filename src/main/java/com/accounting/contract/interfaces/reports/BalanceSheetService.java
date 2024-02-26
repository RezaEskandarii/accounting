package com.accounting.contract.interfaces.reports;

import java.math.BigDecimal;
import java.util.Map;

public interface BalanceSheetService {
    Map<String, BigDecimal> generateBalanceSheet();
}
