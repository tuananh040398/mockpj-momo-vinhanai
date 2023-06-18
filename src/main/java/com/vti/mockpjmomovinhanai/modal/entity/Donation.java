package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "`Donation`")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "donate_by", nullable = false)
    private Account donateBy;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @Column(name = "cash", nullable = false)
    private int cash;

    @Column(name = "donate_type")
    private DonateType donateType;

    @Column(name = "create_date")
    private Date createDate;

}
