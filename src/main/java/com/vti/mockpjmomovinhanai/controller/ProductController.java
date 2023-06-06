package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin("*")
@Validated
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/get-all")
    public List<Product> getAll(){
        return productService.getAll();
    }
}
