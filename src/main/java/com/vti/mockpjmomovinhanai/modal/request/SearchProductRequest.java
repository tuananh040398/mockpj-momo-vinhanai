package com.vti.mockpjmomovinhanai.modal.request;

import com.vti.mockpjmomovinhanai.modal.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductRequest {

    private Set<ProductType> productTypes;


}
