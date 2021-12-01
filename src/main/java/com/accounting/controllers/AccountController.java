package com.accounting.controllers;

import com.accounting.dto.accounts.AccountDTO;
import com.accounting.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(path = "")
    public ResponseEntity<AccountDTO> create(@RequestBody AccountDTO dto) {
        var ac = accountService.create(dto);
        return ResponseEntity.of(Optional.of(ac));
    }

    @GetMapping(path = "")
    public List<AccountDTO> findAll() {
        try {
            var ac = accountService.findAll();
            return ac;
        } catch (Exception e) {
            System.out.println("-----------------------");
            System.out.println("-----------------------");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
