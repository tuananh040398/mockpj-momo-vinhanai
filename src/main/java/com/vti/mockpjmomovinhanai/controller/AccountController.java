package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.request.CreateAccountRequest;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import com.vti.mockpjmomovinhanai.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public Account getById(@PathVariable int id) {
        return accountService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody CreateAccountRequest request) {
        accountService.create(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        accountService.delete(id);
    }
}
