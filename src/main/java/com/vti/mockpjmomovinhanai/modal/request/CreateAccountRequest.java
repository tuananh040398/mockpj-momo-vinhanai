package com.vti.mockpjmomovinhanai.modal.request;

import lombok.Data;

@Data
public class CreateAccountRequest {

    private String username;

    private String password;

    private String fullname;

    private String phone;

    private String email;

    private String address;
}
