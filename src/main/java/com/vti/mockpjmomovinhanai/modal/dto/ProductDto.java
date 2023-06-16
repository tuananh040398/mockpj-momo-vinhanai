package com.vti.mockpjmomovinhanai.modal.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String image;

    private String title;

    private int organizationId;

    private int cash;

    private int maxCash;

    private int donate;
}
