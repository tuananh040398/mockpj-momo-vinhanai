package com.vti.mockpjmomovinhanai.service;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<Product> getAll();

    List<ProductDto> getAll2();

    Product getById(int id);

    void create(CreateProductRequest request);

    Product update(int id, UpdateProductRequest request);

    void delete(int id);

}
