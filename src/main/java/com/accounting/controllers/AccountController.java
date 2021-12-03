package com.accounting.controllers;

import com.accounting.config.APIConfig;
import com.accounting.dto.accounts.AccountDTO;
import com.accounting.dto.accounts.GetAccountDTO;
import com.accounting.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = APIConfig.accountsCtrlName)
@Slf4j
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(path = "")
    public ResponseEntity<GetAccountDTO> create(@RequestBody AccountDTO dto) {
        var ac = accountService.create(dto);
        log.info(ac.toString());
        return ResponseEntity.of(Optional.of(ac));
    }

    @GetMapping(path = "")
    public ResponseEntity<List<GetAccountDTO>> findAll() {
        try {
            return ResponseEntity.of(Optional.of(accountService.findAll()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
