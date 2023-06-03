package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import com.vti.mockpjmomovinhanai.modal.request.CreateDonationRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateDonationRequest;
import com.vti.mockpjmomovinhanai.repository.DonationRepository;
import com.vti.mockpjmomovinhanai.service.IDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService implements IDonationService {

    @Autowired
    public DonationRepository repository;

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

    }

    @Override
    public Donation update(int id, UpdateDonationRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
