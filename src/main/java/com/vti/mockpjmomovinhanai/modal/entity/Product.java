package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", length = 300, nullable = false)
    private String title;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "content",  length = 10000, nullable = false)
    private String content;

    @Column(name = "cash")
    private int cash;

    @Column(name = "max_cash", nullable = false)
    private  int maxCash;

    @Column(name = "type_product", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeProduct typeProduct;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "expired_date", nullable = false)
    private Date expiredDate;


}
