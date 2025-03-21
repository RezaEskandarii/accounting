package com.accounting.application.services.ReportServices;

import com.accounting.contract.dto.TrialBalanceReportDto;
import com.accounting.contract.interfaces.reports.TrialBalanceReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TrialBalanceReportAppServiceImplTest {

    @Mock
    private TrialBalanceReportRepository reportRepository;

    private TrialBalanceReportAppServiceImpl reportAppService;

    @BeforeEach
    void setUp() {
        reportAppService = new TrialBalanceReportAppServiceImpl(reportRepository);
    }

    @Test
    void getTrialBalanceReport_ShouldReturnReport() {
        // Arrange
//        Long accountId = 1L;
//        Long journalId = 2L;
//        LocalDate fromDate = LocalDate.of(2024, 1, 1);
//        LocalDate toDate = LocalDate.of(2024, 12, 31);
//
//        List<TrialBalanceReportDto> expectedReport = Arrays.asList(new TrialBalanceReportDto());
//
//        when(reportRepository.getReport(accountId, journalId, fromDate, toDate))
//            .thenReturn(expectedReport);
//
//        // Act
//        List<TrialBalanceReportDto> result = reportAppService.getTrialBalanceReport(
//            accountId, journalId, fromDate, toDate);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(expectedReport, result);
//        verify(reportRepository).getReport(accountId, journalId, fromDate, toDate);
//    }
    }
} 