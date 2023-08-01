package com.vti.mockpjmomovinhanai.controller;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.dto.ProductDtoGetById;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.entity.ProductType;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import com.vti.mockpjmomovinhanai.repository.ProductRepository;
import com.vti.mockpjmomovinhanai.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@CrossOrigin("*")
@Validated
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/get-all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/get-all-productdto")
    public List<ProductDto> getAllDto() {
        return productService.getAllDto();
    }

    @PostMapping("/search")
    public List<ProductDto> search(@RequestParam ProductType productType) {
        return productService.search(productType);
    }

    @GetMapping("/get-by/{id}")
    public ProductDtoGetById getById(@PathVariable int id) {
        return productService.getProductDtoById(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/create")
    public void create(@RequestBody @Valid CreateProductRequest request) {
        productService.create(request);
    }

    @DeleteMapping("/delete-by/{id}")
    public void deleteById(@PathVariable int id){
        productService.delete(id);
    }

    
}
