package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`Account`")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", length = 50,  unique = true, nullable = false)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "address")
    private String address;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "coin")
    private int coin;
}
