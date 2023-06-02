package com.vti.mockpjmomovinhanai.service;

import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<Product> getAll();

    Product getById(int id);

    void create(CreateProductRequest request);

    Product update(int id, CreateProductRequest request);

    void delete(int id);
}
