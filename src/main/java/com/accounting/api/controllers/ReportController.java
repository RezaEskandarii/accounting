package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.interfaces.ReportAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = APIConfig.REPORT_CONTROLLER)
public class ReportController extends BaseController {

    private final ReportAppService reportAppService;

    public ReportController(ReportAppService reportAppService) {
        this.reportAppService = reportAppService;
    }

    @GetMapping("/trial-balance")
    public ResponseEntity<ApiResponse> getTrialBalanceReport(
            @RequestParam(required = false) Long accountId,
            @RequestParam(required = false) Long journalId,
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate
    ) {

        var trialBalanceReport = reportAppService.getTrialBalanceReport(accountId, journalId, fromDate, toDate);
        var apiResponse = new ApiResponse(trialBalanceReport, HttpStatus.OK);
        return ResponseEntity.ok(apiResponse);
    }
}
