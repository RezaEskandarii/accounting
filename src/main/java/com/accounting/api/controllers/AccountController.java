package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import com.accounting.contract.interfaces.AccountAppService;
import com.accounting.shared.filters.PaginationInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping(path = APIConfig.ACCOUNTS_CONTROLLER)
@Slf4j
@Validated
public class AccountController {

    final AccountAppService accountService;

    final MessageSource messageSource;

    public AccountController(AccountAppService accountService, MessageSource messageSource) {
        this.accountService = accountService;
        this.messageSource = messageSource;
    }


    @PostMapping(path = "")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody AccountCreateDto dto, Locale locale) {

        var data = accountService.create(dto);
        return ResponseEntity.ok(new ApiResponse(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var resp = new ApiResponse(accountService.find(id));
        return ResponseEntity.ok(resp);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {

        var resp = new ApiResponse(accountService.findAll(paginationInput), HttpStatus.OK);
        return ResponseEntity.ok(resp);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody AccountUpdateDto accountDTO,
                                              @PathVariable Long id) {
        var data = accountService.update(id, accountDTO);
        return ResponseEntity.ok(new ApiResponse(data));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.ok(new ApiResponse());
    }

}