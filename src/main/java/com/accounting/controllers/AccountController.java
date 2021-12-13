package com.accounting.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.dto.PaginationInput;
import com.accounting.dto.accounts.AccountDTO;
import com.accounting.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping(path = APIConfig.accountsCtrlName)
@Slf4j
@Validated
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    MessageSource messageSource;

    @PostMapping(path = "")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody AccountDTO dto) {
        var resp = new ApiResponse();

        try {
            resp.data = accountService.create(dto);
            resp.statusCode = HttpStatus.OK;
            resp.message = messageSource.getMessage("http.ok.message", null, Locale.ENGLISH);
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.statusCode = HttpStatus.BAD_GATEWAY;
        }

        return new ResponseEntity<>(resp, resp.statusCode);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var result = new ApiResponse(
                accountService.findById(id),
                HttpStatus.OK
        );
        return new ResponseEntity<>(result, result.statusCode);
    }

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse> findAll(PaginationInput paginationInput) {

        var resp = new ApiResponse(accountService.findAll(paginationInput), HttpStatus.OK);
        return new ResponseEntity<>(resp, resp.statusCode);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@RequestBody AccountDTO accountDTO,
                                              @PathVariable Long id) {
        var resp = new ApiResponse();

        try {
            resp.data = accountService.update(accountDTO, id);
            resp.statusCode = HttpStatus.OK;
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.statusCode = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(resp, resp.statusCode);

    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {

        var resp = new ApiResponse();

        try {
            accountService.delete(id);
            resp.statusCode = HttpStatus.OK;
        } catch (Exception e) {
            log.error(e.getMessage());
            resp.statusCode = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(resp, resp.statusCode);
    }
}
