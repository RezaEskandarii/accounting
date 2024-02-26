package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.contract.interfaces.appservices.AccountGroupAppService;
import com.accounting.shared.filters.PaginationInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = APIConfig.ACCOUNT_GROUPS_CONTROLLER)
@Slf4j
public class AccountGroupController {

    final AccountGroupAppService accountGroupAppService;

    final MessageSource messageSource;

    public AccountGroupController(AccountGroupAppService accountGroupAppService, MessageSource messageSource) {
        this.accountGroupAppService = accountGroupAppService;
        this.messageSource = messageSource;
    }

    @PostMapping(path = "")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody AccountGroupDto dto) {
        var result = accountGroupAppService.create(dto);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var result = new ApiResponse(
                accountGroupAppService.findById(id)
        );
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {

        var result = new ApiResponse(accountGroupAppService.findAll(paginationInput), HttpStatus.OK);
        return ResponseEntity.ok(result);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody AccountGroupDto accountGroupDto, @PathVariable Long id) {
        var result = accountGroupAppService.update(id, accountGroupDto);
        return ResponseEntity.ok(new ApiResponse(result));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {

        accountGroupAppService.delete(id);
        return ResponseEntity.ok(new ApiResponse());
    }
}
