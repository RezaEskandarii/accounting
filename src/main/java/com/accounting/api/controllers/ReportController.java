package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.interfaces.ReportAppService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ReportAppService reportAppService;

    @GetMapping("/trial-balance")
    public ResponseEntity<ApiResponse> getTrialBalanceReport(
            @RequestParam("accountId") long accountId,
            @RequestParam("journalId") long journalId,
            @RequestParam("fromDate") LocalDate fromDate,
            @RequestParam("toDate") LocalDate toDate
    ) {

        var data = reportAppService.getTrialBalanceReport(accountId, journalId, fromDate, toDate);
        var resp = new ApiResponse(data, HttpStatus.OK);
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
}
