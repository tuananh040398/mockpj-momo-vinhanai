package com.vti.mockpjmomovinhanai.repository;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<ProductDto> findAll(Specification<ProductDto> condition);
}
