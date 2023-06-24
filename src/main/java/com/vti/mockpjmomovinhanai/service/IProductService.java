package com.vti.mockpjmomovinhanai.service;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.dto.ProductDtoGetById;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.entity.ProductType;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<Product> getAll();

    List<ProductDto> getAllDto();

    List<ProductDto> search(ProductType productType);

    ProductDtoGetById getProductDtoById(int id);

    Product getById(int id);

    void create(CreateProductRequest request);

    void delete(int id);

}
