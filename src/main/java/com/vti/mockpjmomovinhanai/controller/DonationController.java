package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.entity.Donation;
import com.vti.mockpjmomovinhanai.modal.request.CreateDonationRequest;
import com.vti.mockpjmomovinhanai.service.impl.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/donation")
@CrossOrigin("*")
@Validated
public class DonationController {

    @Autowired
    public DonationService service;

    @GetMapping("/get-all")
    public List<Donation> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Donation getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody CreateDonationRequest request) {
        service.create(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.delete(id);
    }

}
