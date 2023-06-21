package com.vti.mockpjmomovinhanai.modal.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, CUSTOMER;

    @Override
    public String getAuthority() {
        return name();
    }
}
