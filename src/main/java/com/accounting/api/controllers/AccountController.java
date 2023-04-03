package com.accounting.api.controllers;

import com.accounting.commons.ApiResponse;
import com.accounting.config.APIConfig;
import com.accounting.shared.filters.PaginationInput;
import com.accounting.contract.dto.accounts.AccountCreateDto;
import com.accounting.contract.dto.accounts.AccountUpdateDto;
import com.accounting.contract.interfaces.AccountAppService;
import com.accounting.repositories.interfaces.AccountCrudRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AccountAppService accountService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    AccountCrudRepository accountRepository;

    @PostMapping(path = "")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody AccountCreateDto dto, Locale locale) {
        var resp = new ApiResponse();

            resp.data = accountService.create(dto);
            resp.statusCode = HttpStatus.OK;
            resp.message = messageSource.getMessage("http.ok.message", null, locale);

            return new ResponseEntity<>(resp, resp.statusCode);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable Long id) {
        var result = new ApiResponse(
                accountService.find(id),
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
    public ResponseEntity<ApiResponse> update(@RequestBody AccountUpdateDto accountDTO,
                                              @PathVariable Long id) {
        var resp = new ApiResponse();

        resp.data = accountService.update(id, accountDTO);
        resp.statusCode = HttpStatus.OK;

        return new ResponseEntity<>(resp, resp.statusCode);

    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {

        var resp = new ApiResponse();
        accountService.delete(id);
        resp.statusCode = HttpStatus.OK;

        return new ResponseEntity<>(resp, resp.statusCode);
    }



//    @GetMapping("/l")
//    public ResponseEntity<ApiResponse> fff(){
//        var r = new ApiResponse();
//        var t  = new PaginationInput();
//        t.setPageNumber(0);
//        r.data = accountRepository.llll(PageUtils.GetRequest(t));
//        return new ResponseEntity<>(r, HttpStatus.CHECKPOINT);
//    }
}
