package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import com.vti.mockpjmomovinhanai.modal.request.CreateDonationRequest;
import com.vti.mockpjmomovinhanai.service.impl.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/donation")
@CrossOrigin("*")
@Validated
public class DonationController {

    @Autowired
    public DonationService service;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/get-all")
    public List<Donation> getAll(){
        return service.getAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    @GetMapping("/{id}")
    public Donation getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateDonationRequest request) {
        service.create(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
