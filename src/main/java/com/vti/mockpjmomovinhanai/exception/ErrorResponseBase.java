package com.vti.mockpjmomovinhanai.exception;

import org.springframework.http.HttpStatus;

public enum ErrorResponseBase {
    ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "Người dùng không tồn tại"),
    DONATION_NOT_FOUND(HttpStatus.NOT_FOUND, "Quyên góp không tồn tại"),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "Chương trình quyên góp không tồn tại"),
    ORGANIZATION_NOT_FOUND(HttpStatus.NOT_FOUND, "Tổ chức không tồn tại"),
    NOT_ENOUGE_MONEY(HttpStatus.BAD_REQUEST, "Ví Momo của bạn không đủ để thực hiện giao dịch này"),
    TRANSACTION_ERROR(HttpStatus.BAD_REQUEST, "Lỗi giao dịch"),
    MAX_DONATE(HttpStatus.BAD_REQUEST, "Mỗi lần chỉ có thể quyên góp tối đa 2 tỷ"),
    LOGIN_FAILS_USERNAME(HttpStatus.UNAUTHORIZED, "Người dùng không tồn tại"),
    LOGIN_FAILS_PASSWORD(HttpStatus.UNAUTHORIZED, "Mật khẩu không đúng"),
    USERNAME_EXISTED(HttpStatus.INTERNAL_SERVER_ERROR, "Username đã tồn tại"),
    MIN_MAXCASH(HttpStatus.BAD_REQUEST, "Tối đa số tiền quyên góp phải lớn hơn hoặc bằng 1,000,000 VNĐ")
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
