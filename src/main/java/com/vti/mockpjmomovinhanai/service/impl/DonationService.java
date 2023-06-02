package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import com.vti.mockpjmomovinhanai.modal.request.CreateDonationRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateDonationRequest;
import com.vti.mockpjmomovinhanai.service.IDonationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService implements IDonationService {
    @Override
    public List<Donation> getAll() {
        return null;
    }

    @Override
    public Donation getById(int id) {
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
