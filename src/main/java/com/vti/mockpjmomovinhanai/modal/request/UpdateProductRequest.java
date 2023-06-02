package com.vti.mockpjmomovinhanai.modal.request;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private String title;

    private String image;

    private String content;

    private int cash;
}
