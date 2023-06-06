package com.vti.mockpjmomovinhanai.modal.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateDonationRequest {

    private int donateBy;

    private int productId;

    private int cash;

    private Date createDate;
}
