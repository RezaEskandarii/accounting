package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.interfaces.ReportAppService;
import com.accounting.repositories.interfaces.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = APIConfig.REPORT_CONTROLLER)
public class ReportController extends BaseController {

    @Autowired
    private ReportAppService reportAppService;

    @GetMapping("/trial-balance")
    public ResponseEntity<ApiResponse> getTrialBalanceReport() {

        Date date = new Date();
        var data = reportAppService.getTrialBalanceReport(null, null, null, null);
        var resp = new ApiResponse(data, HttpStatus.OK);
        return new ResponseEntity<>(resp, HttpStatus.OK);

    }
}
