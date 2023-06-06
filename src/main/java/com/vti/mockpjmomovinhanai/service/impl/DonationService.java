package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.request.CreateDonationRequest;
import com.vti.mockpjmomovinhanai.repository.DonationRepository;
import com.vti.mockpjmomovinhanai.service.IDonationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DonationService implements IDonationService {

    @Autowired
    public DonationRepository repository;

    @Autowired
    public AccountService accountService;

    @Autowired
    public ProductService productService;

    @Override
    public List<Donation> getAll() {
        return repository.findAll();
    }

    @Override
    public Donation getById(int id) {
        Optional<Donation> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void create(CreateDonationRequest request) {
        Donation donation = new Donation();
        BeanUtils.copyProperties(request, donation);
        Account account = accountService.getById(request.getDonateBy());
        Product product = productService.getById(request.getProductId());
        if (account !=null && product !=null){
            donation.setDonateBy(account);
            donation.setProductId(product);
            donation.setCreateDate(new Date());
            repository.save(donation);
        }
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
