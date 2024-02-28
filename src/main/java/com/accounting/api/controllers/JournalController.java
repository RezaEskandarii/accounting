package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.contract.interfaces.appservices.JournalAppService;
import com.accounting.contract.interfaces.reports.TrialBalanceReportRepository;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = APIConfig.JOURNALS_CONTROLLER)
public class JournalController extends BaseController {


    private final JournalAppService journalAppService;

    private final TrialBalanceReportRepository reportRepository;

    public JournalController(JournalAppService journalAppService, TrialBalanceReportRepository reportRepository) {
        this.journalAppService = journalAppService;
        this.reportRepository = reportRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody JournalDto dto) {
        var result = journalAppService.create(dto);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var result = journalAppService.find(id);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        journalAppService.delete(id);
        return ResponseEntity.ok(new ApiResponse());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody JournalDto dto, @PathVariable Long id) {
        var result = journalAppService.update(id, dto);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {
        var result = journalAppService.findAll(paginationInput);
        return ResponseEntity.ok(new ApiResponse(result));
    }


}
