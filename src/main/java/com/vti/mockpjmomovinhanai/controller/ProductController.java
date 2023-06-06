package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    @Autowired
    IProductService productService;

    @GetMapping("/get-all")
    public List<Product> getAll(){
        return productService.getAll();
    }
=======

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll(){
         List<Product> productList = productService.getAll();

         return new ResponseEntity<>(productList, HttpStatus.OK);
     }
>>>>>>> Stashed changes
}
