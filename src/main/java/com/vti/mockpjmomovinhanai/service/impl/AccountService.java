package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.request.CreateAccountRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateAccountRequest;
import com.vti.mockpjmomovinhanai.repository.AccountRepository;
import com.vti.mockpjmomovinhanai.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    public AccountRepository repository;

    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }

    @Override
    public Account getById(int id) {
        return null;
    }

    @Override
    public void create(CreateAccountRequest request) {

    }

    @Override
    public Account update(int id, UpdateAccountRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
