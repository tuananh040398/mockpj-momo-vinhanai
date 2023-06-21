package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.exception.AppException;
import com.vti.mockpjmomovinhanai.exception.ErrorResponseBase;
import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.entity.Role;
import com.vti.mockpjmomovinhanai.modal.request.CreateAccountRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateAccountRequest;
import com.vti.mockpjmomovinhanai.repository.AccountRepository;
import com.vti.mockpjmomovinhanai.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService, UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optional = repository.findByUsername(username);
        if (optional.isPresent()) {
            Account account = optional.get();
            // Lấy giá trị authorities để phân quyền
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(account.getRole());
            return new User(account.getUsername(), account.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }

    @Override
    public Account getById(int id) {
        Optional<Account> optional = repository.findById(id);
        if (optional.isEmpty()){
            throw new AppException(ErrorResponseBase.ACCOUNT_NOT_FOUND);
        }
        return optional.get();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void create(CreateAccountRequest request) {
        Account account = new Account();
        BeanUtils.copyProperties(request, account);
        // Kiếm tra username đã tồn tại hay chưa
        Optional<Account> accountCheck = repository.findByUsername(request.getUsername());
        if (accountCheck.isPresent()) {
            // username đã tồn tại thì bắn lỗi
            throw new AppException(ErrorResponseBase.USERNAME_EXISTED);
        }
        String encoderpassword = encoder.encode(request.getPassword());
        account.setPassword(encoderpassword);
        account.setRole(Role.CUSTOMER);
        repository.save(account);
    }

    @Override
    public Account update(int id, UpdateAccountRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
