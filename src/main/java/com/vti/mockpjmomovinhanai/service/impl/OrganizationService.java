package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.modal.entity.Organization;
import com.vti.mockpjmomovinhanai.modal.request.CreateOrganizationRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateOrganizationRequest;
import com.vti.mockpjmomovinhanai.service.IOrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService implements IOrganizationService {
    @Override
    public List<Organization> getAll() {
        return null;
    }

    @Override
    public Organization getById(int id) {
        return null;
    }

    @Override
    public void create(CreateOrganizationRequest request) {

    }

    @Override
    public Organization update(int id, UpdateOrganizationRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
