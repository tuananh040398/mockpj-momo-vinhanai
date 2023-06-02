package com.vti.mockpjmomovinhanai.modal.request;

import com.vti.mockpjmomovinhanai.modal.entity.Account;
import com.vti.mockpjmomovinhanai.modal.entity.Product;
import lombok.Data;

import java.util.Date;

@Data
public class CreateDonationRequest {

    private Account donateBy;

    private Product productId;

    private int cash;

    private Date createDate;
}
