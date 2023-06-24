package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.entity.Organization;
import com.vti.mockpjmomovinhanai.service.impl.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/organization")
@CrossOrigin("*")
@Validated
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/get-all")
    public List<Organization> getAll() {
        return organizationService.getAll();
    }

    @GetMapping("/get-by/{id}")
    public Organization getById(@PathVariable int id) {
        return organizationService.getById(id);
    }
}
