package com.vti.mockpjmomovinhanai.repository;

import com.vti.mockpjmomovinhanai.modal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
