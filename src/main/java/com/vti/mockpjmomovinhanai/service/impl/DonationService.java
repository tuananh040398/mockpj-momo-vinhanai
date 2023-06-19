package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.exception.AppException;
import com.vti.mockpjmomovinhanai.exception.ErrorResponseBase;
import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.entity.DonateType;
import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.request.CreateDonationRequest;
import com.vti.mockpjmomovinhanai.repository.AccountRepository;
import com.vti.mockpjmomovinhanai.repository.DonationRepository;
import com.vti.mockpjmomovinhanai.repository.ProductRepository;
import com.vti.mockpjmomovinhanai.service.IDonationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DonationService implements IDonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation getById(int id) {
        Optional<Donation> optional = donationRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppException(ErrorResponseBase.DONATION_NOT_FOUND);
        }
        return optional.get();
    }

//    @Override
//    public void create(CreateDonationRequest request) {
//        Donation donation = new Donation();
//        BeanUtils.copyProperties(request, donation);
//        Account account = accountService.getById(request.getDonateBy());
//        Product product = productService.getById(request.getProductId());
//        if (account !=null && product !=null){
//            donation.setDonateBy(account);
//            donation.setProductId(product);
//            donation.setCreateDate(new Date());
//            repository.save(donation);
//        }
//    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void create(CreateDonationRequest request) {
        Donation donation = new Donation();
        BeanUtils.copyProperties(request, donation);
        Account account = accountService.getById(request.getDonateBy());
        Product product = productService.getById(request.getProductId());
        if (account !=null && product !=null){
            if (request.getCash() > account.getCash()) {
                throw new AppException(ErrorResponseBase.NOT_ENOUGE_MONEY);
            }
                donation.setDonateBy(account);
                donation.setProductId(product);
                account.setCash(account.getCash() - request.getCash());
                product.setCash(product.getCash() + request.getCash());
                donation.setDonateType(DonateType.MOMO);
                donation.setCreateDate(new Date());
                donationRepository.save(donation);
                accountRepository.save(account);
                productRepository.save(product);
        } else {
            throw new AppException(ErrorResponseBase.TRANSACTION_ERROR);
        }
    }

    @Override
    public void delete(int id) {
        donationRepository.deleteById(id);
    }
}
