package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import com.accounting.contract.interfaces.appservices.AccountAppService;
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

        var result = accountService.create(dto);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var result = new ApiResponse(accountService.find(id));
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {

        var result = new ApiResponse(accountService.findAll(paginationInput), HttpStatus.OK);
        return ResponseEntity.ok(result);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody AccountUpdateDto accountDTO, @PathVariable Long id) {
        var result = accountService.update(id, accountDTO);
        return ResponseEntity.ok(new ApiResponse(result));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.ok(new ApiResponse());
    }

}