package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import com.vti.mockpjmomovinhanai.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public void create(CreateProductRequest request) {

    }

    @Override
    public Product update(int id, CreateProductRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
