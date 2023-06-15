package com.vti.mockpjmomovinhanai.modal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String image;

    private String title;

    private String organizationId;

    private int cash;

    private int maxCash;

    private int donate;
}
