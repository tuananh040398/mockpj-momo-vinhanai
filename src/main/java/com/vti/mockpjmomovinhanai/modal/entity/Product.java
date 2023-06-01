package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
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

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "oranize_id", nullable = false)
    private Organize organizeId;

    @Column(name = "cash", nullable = false)
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

    @Column(name = "confirm", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductConfirm confirm;
}
