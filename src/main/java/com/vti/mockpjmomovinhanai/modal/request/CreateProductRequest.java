package com.vti.mockpjmomovinhanai.modal.request;

import com.vti.mockpjmomovinhanai.modal.entity.ProductType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class CreateProductRequest {

    private String title;

    private String image;

    private String content;

    private int organizationId;

    private Long cash;

    private  Long maxCash;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private Date createDate;

    private Date expiredDate;
}
