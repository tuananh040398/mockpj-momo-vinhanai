package com.vti.mockpjmomovinhanai.modal.request;

import com.vti.mockpjmomovinhanai.modal.entity.DonateType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class CreateDonationRequest {

    private int donateBy;

    private int productId;

    private int cash;

    @Enumerated(EnumType.STRING)
    private DonateType donateType;

    private Date createDate;
}
