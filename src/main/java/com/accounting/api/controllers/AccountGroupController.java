package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.contract.dto.accountGroups.AccountGroupDto;
import com.accounting.contract.interfaces.AccountGroupAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

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
        var resp = new ApiResponse();

        resp.data = accountGroupAppService.create(dto);
        resp.statusCode = HttpStatus.OK;
        resp.message = messageSource.getMessage("http.ok.message", null, Locale.ENGLISH);

        return new ResponseEntity<>(resp, resp.statusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var result = new ApiResponse(
                accountGroupAppService.findById(id),
                HttpStatus.OK
        );
        return new ResponseEntity<>(result, result.statusCode);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {

        var resp = new ApiResponse(accountGroupAppService.findAll(paginationInput), HttpStatus.OK);
        return new ResponseEntity<>(resp, resp.statusCode);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody AccountGroupDto accountGroupDto,
                                              @PathVariable Long id) {
        var resp = new ApiResponse();

        resp.data = accountGroupAppService.update(id, accountGroupDto);
        resp.statusCode = HttpStatus.OK;

        return new ResponseEntity<>(resp, resp.statusCode);

    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {

        var resp = new ApiResponse();
        accountGroupAppService.delete(id);
        resp.statusCode = HttpStatus.OK;

        return new ResponseEntity<>(resp, resp.statusCode);
    }
}
