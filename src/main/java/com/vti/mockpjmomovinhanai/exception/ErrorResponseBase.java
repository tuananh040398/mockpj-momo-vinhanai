package com.vti.mockpjmomovinhanai.exception;

import org.springframework.http.HttpStatus;

public enum ErrorResponseBase {
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "Người dùng không tồn tại"),
    DONATION_NOT_FOUND(HttpStatus.NOT_FOUND, "Quyên góp không tồn tại"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Chương trình quyên góp không tồn tại"),
    ORGANIZATION_NOT_FOUND(HttpStatus.NOT_FOUND, "Tổ chức không tồn tại"),
    NOT_ENOUGE_MONEY(HttpStatus.BAD_REQUEST, "Ví Momo của bạn không đủ để thực hiện giao dịch này"),
    TRANSACTION_ERROR(HttpStatus.BAD_REQUEST, "Lỗi giao dịch"),
    LOGIN_FAILS_USERNAME(HttpStatus.UNAUTHORIZED, "Người dùng không tồn tại"),
    LOGIN_FAILS_PASSWORD(HttpStatus.UNAUTHORIZED, "Mật khẩu không đúng")
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
