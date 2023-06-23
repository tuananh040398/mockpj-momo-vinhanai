package com.vti.mockpjmomovinhanai.service;

import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import com.vti.mockpjmomovinhanai.modal.request.CreateDonationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDonationService {
    List<Donation> getAll();

    Donation getById(int id);

    void create(CreateDonationRequest request);

}
