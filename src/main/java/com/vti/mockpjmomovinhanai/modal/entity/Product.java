package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
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

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organizationId;

    @Column(name = "cash", nullable = false)
    private int cash;

    @Column(name = "max_cash", nullable = false)
    private  int maxCash;

    @Column(name = "product_type", nullable = false)
    @Convert(converter = ProductTypeConverter.class)
    private String productType;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "expired_date", nullable = false)
    private Date expiredDate;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductStatus confirm;

    @OneToMany(mappedBy = "productId")
    private List<Donation> donations;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", organizationId=" + organizationId +
                ", cash=" + cash +
                ", maxCash=" + maxCash +
                ", productType='" + productType + '\'' +
                ", createDate=" + createDate +
                ", expiredDate=" + expiredDate +
                ", confirm=" + confirm +
                ", donations=" + donations.size() +
                '}';
    }
}
