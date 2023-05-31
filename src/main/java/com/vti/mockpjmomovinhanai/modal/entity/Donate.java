package com.vti.mockpjmomovinhanai.modal.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "`Donate`")
public class Donate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "donate_by")
    private Account donateBy;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(name = "create_date")
    private Date createDate;
}
