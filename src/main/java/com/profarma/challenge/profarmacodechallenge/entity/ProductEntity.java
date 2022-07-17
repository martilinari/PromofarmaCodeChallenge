package com.profarma.challenge.profarmacodechallenge.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    private Long id;

    @Column(name = "product_name")
    private String productName;

    private Set<SellerProductEntity> sellerProduct = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @OneToMany(mappedBy = "primaryKey.product", cascade = CascadeType.ALL)
    public Set<SellerProductEntity> getSellerProduct() {
        return sellerProduct;
    }

    public void setSellerProduct(Set<SellerProductEntity> sellerProduct) {
        this.sellerProduct = sellerProduct;
    }

}
