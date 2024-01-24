package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.journal.JournalDto;
import com.accounting.contract.interfaces.JournalAppService;
import com.accounting.crudrepositories.interfaces.ReportRepository;
import com.accounting.shared.filters.PaginationInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping(value = APIConfig.JOURNALS_CONTROLLER)
public class JournalController extends BaseController {


    private final JournalAppService journalAppService;

    private final ReportRepository reportRepository;

    public JournalController(JournalAppService journalAppService, ReportRepository reportRepository) {
        this.journalAppService = journalAppService;
        this.reportRepository = reportRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody JournalDto dto) {
        var resp = new ApiResponse()
                .setData(journalAppService.create(dto))
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var resp = new ApiResponse()
                .setData(journalAppService.find(id))
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {

        journalAppService.delete(id);
        var resp = new ApiResponse()
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody JournalDto dto, @PathVariable Long id, Locale locale) {
        var resp = new ApiResponse()
                .setData(journalAppService.update(id, dto))
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {
        var resp = new ApiResponse()
                .setData(journalAppService.findAll(paginationInput))
                .setStatusCode(HttpStatus.OK);

        return ResponseEntity.ok(resp);
    }


}
