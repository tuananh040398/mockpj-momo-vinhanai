package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.PrivilegedAction;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName", length = 50)
    private String firstName;

    @Column(name = "firstName", length = 50)
    private String lastName;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "role")
    private Role role;

    @Column(name = "countDonations", nullable = false)
    private int countDonations;

    public enum Role {
        ADMIN, USER
    }

    @PrePersist
    public void prePersist() {
        if (role == null) {
            role = Role.USER; // Gán giá trị mặc định là Role.USER nếu trường role chưa được gán giá trị
        }
    }
}
