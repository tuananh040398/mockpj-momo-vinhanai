package com.vti.mockpjmomovinhanai.modal.request;

import com.vti.mockpjmomovinhanai.modal.entity.ProductType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class CreateProductRequest {

    private String title;

    private String image;

    private String content;

    private int organizationId;

    @Min(value = 1000000, message = "Tối đa số tiền quyên góp phải lớn hơn hoặc bằng 1,000,000 VNĐ")
    private  Long maxCash;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private Date expiredDate;
}
