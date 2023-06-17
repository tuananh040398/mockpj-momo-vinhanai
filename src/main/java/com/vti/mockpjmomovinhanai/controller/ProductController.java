package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.repository.DonationRepository;
import com.vti.mockpjmomovinhanai.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin("*")
@Validated
public class ProductController {
    @Autowired
    IProductService productService;


    @GetMapping("/get-all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/get-all-productdto")
    public List<ProductDto> getAllDto() {
        return productService.getAllDto();
    }


    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }
}
