package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.exception.AppException;
import com.vti.mockpjmomovinhanai.exception.ErrorResponseBase;
import com.vti.mockpjmomovinhanai.modal.entity.Organization;
import com.vti.mockpjmomovinhanai.modal.request.CreateOrganizationRequest;
import com.vti.mockpjmomovinhanai.repository.OrganizationRepository;
import com.vti.mockpjmomovinhanai.service.IOrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService implements IOrganizationService {

    @Autowired
    private OrganizationRepository repository;

    @Override
    public List<Organization> getAll() {
        return repository.findAll();
    }

    @Override
    public Organization getById(int id) {
        Optional<Organization> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new AppException(ErrorResponseBase.ORGANIZATION_NOT_FOUND);
        }
        return optional.get();
    }

    @Override
    public void create(CreateOrganizationRequest request) {
        Organization organization = new Organization();
        BeanUtils.copyProperties(request, organization);
        Optional<Organization> organizationCheck = repository.findOrganizationByName(request.getName());
        if (organizationCheck.isPresent()) {
            throw new AppException(ErrorResponseBase.ORGANIZATION_EXISTED);
        }
        repository.save(organization);
    }

}
