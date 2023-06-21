package com.vti.mockpjmomovinhanai.modal.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateAccountRequest {

    @NotBlank(message = "Tên không được để trống")
    private String username;

    @NotBlank(message = "Password không được để trống")
    @Size(min = 6, max = 20, message = "password phải có 6-20 ký tự")
    private String password;

    private String fullname;

    private String phone;

    private String email;

    private String address;
}
