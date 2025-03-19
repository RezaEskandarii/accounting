package com.accounting.application.services.ReportServices;

import com.accounting.domain.interfaces.repository.BalanceSheetReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BalanceSheetReportAppServiceImplTest {

    @Mock
    private BalanceSheetReportRepository balanceSheetReportRepository;

    private BalanceSheetReportAppServiceImpl balanceSheetReportAppService;

    @BeforeEach
    void setUp() {
        balanceSheetReportAppService = new BalanceSheetReportAppServiceImpl(balanceSheetReportRepository);
    }

    @Test
    void generateBalanceSheet_ShouldReturnBalanceSheet() {
        // Arrange
        Map<String, BigDecimal> expectedBalanceSheet = new HashMap<>();
        expectedBalanceSheet.put("Assets", new BigDecimal("1000.00"));
        expectedBalanceSheet.put("Liabilities", new BigDecimal("500.00"));
        expectedBalanceSheet.put("Equity", new BigDecimal("500.00"));
        
        when(balanceSheetReportRepository.generateBalanceSheet()).thenReturn(expectedBalanceSheet);

        // Act
        Map<String, BigDecimal> result = balanceSheetReportAppService.generateBalanceSheet();

        // Assert
        assertNotNull(result);
        assertEquals(expectedBalanceSheet, result);
        assertEquals(3, result.size());
        assertEquals(new BigDecimal("1000.00"), result.get("Assets"));
        assertEquals(new BigDecimal("500.00"), result.get("Liabilities"));
        assertEquals(new BigDecimal("500.00"), result.get("Equity"));
        verify(balanceSheetReportRepository).generateBalanceSheet();
    }
} 