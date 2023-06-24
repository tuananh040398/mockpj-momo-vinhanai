package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organizationId;

    @Column(name = "cash", nullable = false)
    private Long cash;

    @Column(name = "max_cash", nullable = false)
    private  Long maxCash;

    @Column(name = "product_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "expired_date", nullable = false)
    private Date expiredDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus confirm;

    @OneToMany(mappedBy = "productId")
    private List<Donation> donations;
    
}
