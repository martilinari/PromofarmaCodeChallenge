package com.profarma.challenge.profarmacodechallenge.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seller")
public class SellerEntity {


    private Long id;

    @Column(name = "seller_name")
    private String sellerName;

    private Set<SellerProductEntity> sellerProduct = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELLER_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @OneToMany(mappedBy = "primaryKey.seller", cascade = CascadeType.ALL)
    public Set<SellerProductEntity> getSellerProduct() {
        return sellerProduct;
    }

    public void setSellerProduct(Set<SellerProductEntity> sellerProduct) {
        this.sellerProduct = sellerProduct;
    }
}
