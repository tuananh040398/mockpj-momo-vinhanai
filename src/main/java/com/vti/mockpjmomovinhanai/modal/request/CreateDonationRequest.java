package com.vti.mockpjmomovinhanai.modal.request;

import com.vti.mockpjmomovinhanai.modal.entity.DonateType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;

import java.util.Date;

@Data
public class CreateDonationRequest {

    private int donateBy;

    private int productId;

    @Min(value = 1000, message = "Số tiền quyên góp phải lớn hơn hoặc bằng 1,000 VNĐ")
    private Long cash;

    @Enumerated(EnumType.STRING)
    private DonateType donateType;

    private Date createDate;
}
