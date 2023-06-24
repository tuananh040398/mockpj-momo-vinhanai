package com.vti.mockpjmomovinhanai.modal.dto;

import lombok.Data;

@Data
public class ProductDto {

    private int id;

    private String image;

    private String title;

    private String organizationLogo;

    private String organizationName;

    private Long cash;

    private Long maxCash;

    private String productType;

    private int donate;


}
