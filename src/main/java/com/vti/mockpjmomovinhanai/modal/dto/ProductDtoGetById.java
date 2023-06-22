package com.vti.mockpjmomovinhanai.modal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoGetById {

    private int id;

    private String title;

    private String image;

    private String content;

    private String organizationName;

    private Long cash;

    private Long maxCash;

}
