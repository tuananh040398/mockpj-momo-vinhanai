package com.vti.mockpjmomovinhanai.service.impl;

import com.vti.mockpjmomovinhanai.exception.AppException;
import com.vti.mockpjmomovinhanai.exception.ErrorResponseBase;
import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.dto.ProductDtoGetById;
import com.vti.mockpjmomovinhanai.modal.entity.Organization;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import com.vti.mockpjmomovinhanai.modal.entity.ProductStatus;
import com.vti.mockpjmomovinhanai.modal.entity.ProductType;
import com.vti.mockpjmomovinhanai.modal.request.CreateProductRequest;
import com.vti.mockpjmomovinhanai.repository.OrganizationRepository;
import com.vti.mockpjmomovinhanai.repository.ProductRepository;
import com.vti.mockpjmomovinhanai.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private OrganizationService organizationService;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductDto> getAllDto() {
        List<Product> products =  getAll();

        List<ProductDto> response = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            productDto.setOrganizationLogo(product.getOrganizationId().getLogo());
            productDto.setOrganizationName(product.getOrganizationId().getName());
            productDto.setProductType(product.getProductType().toString());
            productDto.setDonate(product.getDonations().size()); // C1
//            productDto.setDonate(donationRepository.countDonateBy(product.getId())); // cách 2
            response.add(productDto);
        }
        return response;
    }


    @Override
    public List<ProductDto> search(ProductType productType) {
        List<Product> products = repository.findAllByProductType(productType);
        List<ProductDto> response = new ArrayList<>();
        for (Product product: products) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            productDto.setOrganizationLogo(product.getOrganizationId().getLogo());
            productDto.setOrganizationName(product.getOrganizationId().getName());
            productDto.setProductType(product.getProductType().toString());
            productDto.setDonate(product.getDonations().size());
            response.add(productDto);
        }
        return response;
    }

    @Override
    public Product getById(int id) {
        Optional<Product> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new AppException(ErrorResponseBase.PRODUCT_NOT_FOUND);
        }
        return optional.get();
    }

    @Override
    public ProductDtoGetById getProductDtoById(int id) {
        Product product = getById(id);
        ProductDtoGetById productDtoGetById = new ProductDtoGetById();
        BeanUtils.copyProperties(product, productDtoGetById);

        productDtoGetById.setOrganizationName(product.getOrganizationId().getName());

        return productDtoGetById;
    }

    @Override
    public void create(CreateProductRequest request) {
        Product product = new Product();
        BeanUtils.copyProperties(request, product);
        Organization organization = organizationService.getById(request.getOrganizationId());
        if (organization != null) {
                product.setOrganizationId(organization);
                product.setCash(Long.valueOf(0));
                product.setConfirm(ProductStatus.WAITING);
                product.setCreateDate(new Date());
                repository.save(product);
        }

    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

}
