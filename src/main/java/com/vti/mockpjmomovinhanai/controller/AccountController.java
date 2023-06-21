package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.request.CreateAccountRequest;
import com.vti.mockpjmomovinhanai.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/account")
@CrossOrigin("*")
@Validated
public class AccountController {

    @Autowired
    IAccountService accountService;

    @GetMapping("/get-all")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Account account = accountService.getById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(account);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateAccountRequest request) {
        accountService.create(request);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        accountService.delete(id);
    }
}
