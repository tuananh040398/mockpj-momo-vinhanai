package com.vti.mockpjmomovinhanai.service;

import com.vti.mockpjmomovinhanai.modal.entity.Organization;
import com.vti.mockpjmomovinhanai.modal.request.CreateOrganizationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrganizationService {
    List<Organization> getAll();

    Organization getById(int id);

    void create(CreateOrganizationRequest request);

}
