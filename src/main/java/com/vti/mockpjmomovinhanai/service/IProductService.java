package com.vti.mockpjmomovinhanai.service;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.dto.ProductDtoGetById;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import com.vti.mockpjmomovinhanai.modal.request.SearchProductRequest;
import com.vti.mockpjmomovinhanai.modal.request.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<Product> getAll();

    List<ProductDto> getAllDto();

    List<ProductDto> search(SearchProductRequest request);

    ProductDtoGetById getProductDtoById(int id);

    Product getById(int id);

    void create(CreateProductRequest request);

    void update(int id, UpdateProductRequest request);;

    void delete(int id);

}
