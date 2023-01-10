package com.accounting.shared.filters;

import com.accounting.shared.enums.TrialBalanceFilterLevels;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrialBalanceFilter extends BaseFilter {
    TrialBalanceFilterLevels level;
    long bookId;
    String fromDate;
    String toDate;
}
