package com.vti.mockpjmomovinhanai.repository.specification;

import com.vti.mockpjmomovinhanai.modal.dto.ProductDto;
import com.vti.mockpjmomovinhanai.modal.entity.ProductType;
import com.vti.mockpjmomovinhanai.modal.request.SearchProductRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

public class ProductSpecification {

    public static Specification<ProductDto> buildCondition(SearchProductRequest request) {
        return  Specification.where(byProductType(request.getProductTypes()));
    }

    private static Specification<ProductDto> byProductType(Set<ProductType> productTypes) {
        if (productTypes != null) {
            return (root, query, cri) -> {
                return root.get("productType").in(productTypes);
            };
        }
        return null;
    }
}
