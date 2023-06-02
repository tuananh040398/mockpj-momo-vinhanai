package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`Organization`")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "information",length = 2000)
    private String information;
}
