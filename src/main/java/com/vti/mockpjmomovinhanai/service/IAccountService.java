package com.vti.mockpjmomovinhanai.service;

import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.request.CreateAccountRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateAccountRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAccountService {
    List<Account> getAll();

    Account getById(int id);

    void create(CreateAccountRequest request);

    Account update(int id, UpdateAccountRequest request);

    void delete(int id);
}
