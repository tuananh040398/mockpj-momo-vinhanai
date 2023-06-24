package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`Account`")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50,  unique = true, nullable = false, updatable = false)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullname;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "cash")
    private Long cash;

    @PrePersist
    public void prePersist() {
        if (password == null) {
            password = new BCryptPasswordEncoder().encode("123456");
        }
    }
}
