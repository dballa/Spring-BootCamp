package com.shopboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "product", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigInteger price;

    @Column(name = "valid")
    private boolean valid;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
    private BarberShopEntity barberShop;

}
