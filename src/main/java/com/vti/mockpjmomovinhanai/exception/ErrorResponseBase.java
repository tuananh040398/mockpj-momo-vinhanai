package com.vti.mockpjmomovinhanai.exception;

import org.springframework.http.HttpStatus;

public enum ErrorResponseBase {
    NOT_FOUND(HttpStatus.NOT_FOUND, "Đối tượng không tồn tại"),
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "Người dùng không tồn tại"),
    DONATION_NOT_FOUND(HttpStatus.NOT_FOUND, "Quyên góp không tồn tại"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Chương trình quyên góp không tồn tại"),
    DONATION_OR_ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "Người dùng hoặc chương trình quyên góp không tồn tại")
    ;

    public final HttpStatus status;
    public final String message;


    ErrorResponseBase(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
