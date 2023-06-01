package com.vti.mockpjmomovinhanai.modal.request;

import lombok.Data;

@Data
public class UpdateAccountRequest {

    private String password;

    private String fullname;

    private String phone;

    private String email;

    private String address;
}
